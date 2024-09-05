package com.dk.dao;

//UserDAO.java - Data Access Object for User operations
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dk.db.DB;
import com.dk.entity.User;

public class UserDAO {
 public boolean validateUser(String username, String password) {
     String query = "SELECT * FROM users WHERE username = ? AND password = ?";
     try (Connection con = DB.getConnection();
          PreparedStatement pst = con.prepareStatement(query)) {
         pst.setString(1, username);
         pst.setString(2, password);
         try (ResultSet rs = pst.executeQuery()) {
             return rs.next();
         }
     } catch (SQLException e) {
         e.printStackTrace();
         return false;
     }
 }

 public void registerUser(String username, String password, String email) {
     String query = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
     try (Connection con = DB.getConnection();
          PreparedStatement pst = con.prepareStatement(query)) {
         pst.setString(1, username);
         pst.setString(2, password);
         pst.setString(3, email);
         pst.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public User getUserByUsername(String username) {
     String query = "SELECT * FROM users WHERE username = ?";
     try (Connection con = DB.getConnection();
          PreparedStatement pst = con.prepareStatement(query)) {
         pst.setString(1, username);
         try (ResultSet rs = pst.executeQuery()) {
             if (rs.next()) {
                 User user = new User();
                 user.setId(rs.getInt("id"));
                 user.setUsername(rs.getString("username"));
                 user.setEmail(rs.getString("email"));
                 user.setAdmin(rs.getBoolean("is_admin"));
                 return user;
             }
         }
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return null;
 }
}


