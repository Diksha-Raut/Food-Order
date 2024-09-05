package com.dk.servlet;

import java.io.IOException;

//LoginServlet.java - Handles user login
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dk.dao.UserDAO;
import com.dk.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     String username = request.getParameter("username");
     String password = request.getParameter("password");

     UserDAO userDAO = new UserDAO();
     if (userDAO.validateUser(username, password)) {
         request.getSession().setAttribute("username", username);
         User user = userDAO.getUserByUsername(username);
         request.getSession().setAttribute("user", user);
         response.sendRedirect("menu");
     } else {
         request.setAttribute("errorMessage", "Invalid credentials");
         request.getRequestDispatcher("login.jsp").forward(request, response);
     }
 }
}
