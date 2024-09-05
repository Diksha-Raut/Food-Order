package com.dk.dao;

// FoodItemDAO.java - Data Access Object for Food Item operations
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dk.db.DB;
import com.dk.entity.FoodItem;

public class FoodItemDAO {
    public List<FoodItem> getAllFoodItems() {
        List<FoodItem> foodItems = new ArrayList<>();
        String query = "SELECT * FROM food_items";
        try (Connection con = DB.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                FoodItem item = new FoodItem();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));
                item.setDescription(rs.getString("description"));
                item.setPrice(rs.getDouble("price"));
                foodItems.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foodItems;
    }

    public void addFoodItem(FoodItem item) {
        String query = "INSERT INTO food_items (name, description, price) VALUES (?, ?, ?)";
        try (Connection con = DB.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, item.getName());
            pst.setString(2, item.getDescription());
            pst.setDouble(3, item.getPrice());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public FoodItem getFoodItemById(int foodItemId) {
        FoodItem foodItem = null;
        String query = "SELECT * FROM food_items WHERE id = ?";

        try (Connection con = DB.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setInt(1, foodItemId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                foodItem = new FoodItem();
                foodItem.setId(rs.getInt("id"));
                foodItem.setName(rs.getString("name"));
                foodItem.setDescription(rs.getString("description"));
                foodItem.setPrice(rs.getDouble("price"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return foodItem;
    }

    // Additional methods for update, delete food items can be added here
}
