package com.dk.dao;

//OrderDAO.java - Data Access Object for Order operations
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dk.db.DB;
import com.dk.entity.Order;
import com.dk.entity.OrderDetail;

public class OrderDAO {
 public int createOrder(int userId, List<OrderDetail> orderDetails, double totalAmount) {
     String orderQuery = "INSERT INTO orders (user_id, total_amount) VALUES (?, ?)";
     String orderDetailQuery = "INSERT INTO order_details (order_id, food_item_id, quantity, price) VALUES (?, ?, ?, ?)";
     try (Connection con = DB.getConnection();
          PreparedStatement orderPst = con.prepareStatement(orderQuery, PreparedStatement.RETURN_GENERATED_KEYS);
          PreparedStatement orderDetailPst = con.prepareStatement(orderDetailQuery)) {
         
         // Insert the order
         orderPst.setInt(1, userId);
         orderPst.setDouble(2, totalAmount);
         orderPst.executeUpdate();

         // Get generated order ID
         ResultSet rs = orderPst.getGeneratedKeys();
         if (rs.next()) {
             int orderId = rs.getInt(1);

             // Insert order details
             for (OrderDetail detail : orderDetails) {
                 orderDetailPst.setInt(1, orderId);
                 orderDetailPst.setInt(2, detail.getFoodItemId());
                 orderDetailPst.setInt(3, detail.getQuantity());
                 orderDetailPst.setDouble(4, detail.getPrice());
                 orderDetailPst.executeUpdate();
             }

             return orderId;
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return -1;
 }

 public List<Order> getOrdersByUserId(int userId) {
     List<Order> orders = new ArrayList<>();
     String query = "SELECT * FROM orders WHERE user_id = ?";
     try (Connection con = DB.getConnection();
          PreparedStatement pst = con.prepareStatement(query)) {
         pst.setInt(1, userId);
         try (ResultSet rs = pst.executeQuery()) {
             while (rs.next()) {
                 Order order = new Order();
                 order.setId(rs.getInt("id"));
                 order.setUserId(rs.getInt("user_id"));
                 order.setOrderDate(rs.getTimestamp("order_date"));
                 order.setTotalAmount(rs.getDouble("total_amount"));
                 orders.add(order);
             }
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return orders;
 }

 // Additional methods for retrieving all orders for admin can be added here
}
