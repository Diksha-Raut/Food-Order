package com.dk.servlet;

import java.io.IOException;
import java.util.List;

//MenuServlet.java - Handles menu display
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dk.dao.FoodItemDAO;
import com.dk.entity.FoodItem;

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     FoodItemDAO foodItemDAO = new FoodItemDAO();
     List<FoodItem> foodItems = foodItemDAO.getAllFoodItems();
     request.setAttribute("foodItems", foodItems);
     request.getRequestDispatcher("menu.jsp").forward(request, response);
 }
}
