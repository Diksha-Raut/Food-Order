package com.dk.servlet;

//RegisterServlet.java - Handles user registration
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dk.dao.UserDAO;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     String username = request.getParameter("username");
     String password = request.getParameter("password");
     String email = request.getParameter("email");

     UserDAO userDAO = new UserDAO();
     userDAO.registerUser(username, password, email);
     response.sendRedirect("login.jsp");
 }
}
