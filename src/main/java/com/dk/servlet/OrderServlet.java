package com.dk.servlet;

import com.dk.dao.FoodItemDAO;
import com.dk.dao.OrderDAO;
import com.dk.entity.FoodItem;
import com.dk.entity.OrderDetail;
import com.dk.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            // Redirect to login page if the user is not logged in
            response.sendRedirect("login.jsp");
            return;
        }

        // Retrieve the food items from the request
        String[] foodItemIds = request.getParameterValues("foodItemId");
        String[] quantities = request.getParameterValues("quantity");

        if (foodItemIds != null && quantities != null) {
            List<OrderDetail> orderDetails = new ArrayList<>();
            double totalAmount = 0.0;

            for (int i = 0; i < foodItemIds.length; i++) {
                int foodItemId = Integer.parseInt(foodItemIds[i]);
                int quantity = Integer.parseInt(quantities[i]);

                FoodItemDAO foodItemDAO = new FoodItemDAO();
                FoodItem foodItem = foodItemDAO.getFoodItemById(foodItemId);
                double itemTotal = foodItem.getPrice() * quantity;

                OrderDetail detail = new OrderDetail();
                detail.setFoodItemId(foodItemId);
                detail.setQuantity(quantity);
                detail.setPrice(itemTotal);
                orderDetails.add(detail);

                totalAmount += itemTotal;
            }

            // Create the order using OrderDAO
            OrderDAO orderDAO = new OrderDAO();
            int orderId = orderDAO.createOrder(user.getId(), orderDetails, totalAmount);

            // Forward to order confirmation page or show a success message
            request.setAttribute("orderId", orderId);
            request.getRequestDispatcher("order_confirmation.jsp").forward(request, response);
        } else {
            // Handle the case where no food items or quantities are provided
            request.setAttribute("error", "No items selected for the order.");
            request.getRequestDispatcher("menu").forward(request, response);
        }
    }
}
