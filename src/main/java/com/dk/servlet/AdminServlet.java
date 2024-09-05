package com.dk.servlet;

import com.dk.dao.FoodItemDAO;
import com.dk.db.DB;
import com.dk.entity.FoodItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
//AdminServlet.java - Handles admin operations for menu management
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     FoodItemDAO foodItemDAO = new FoodItemDAO();
     List<FoodItem> foodItems = foodItemDAO.getAllFoodItems();
     request.setAttribute("foodItems", foodItems);
     request.getRequestDispatcher("admin.jsp").forward(request, response);
 }

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     String action = request.getParameter("action");

     if ("add".equals(action)) {
         String name = request.getParameter("name");
         String description = request.getParameter("description");
         double price = Double.parseDouble(request.getParameter("price")); 

         FoodItem item = new FoodItem();
         item.setName(name);
         item.setDescription(description);
         item.setPrice(price);

         FoodItemDAO foodItemDAO = new FoodItemDAO();
         foodItemDAO.addFoodItem(item);

         response.sendRedirect("admin");
     }
 }
}
