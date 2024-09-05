<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.dk.entity.Order" %>
<%@ page import="com.dk.entity.OrderDetail" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>View Orders</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .order-container {
            max-width: 800px;
            margin: 0 auto;
        }
        .order-item {
            margin-bottom: 20px;
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
        .order-item h3 {
            margin-bottom: 10px;
        }
        .order-item ul {
            list-style-type: none;
            padding: 0;
        }
        .order-item ul li {
            padding: 5px 0;
        }
    </style>
</head>
<body>
    <div class="container order-container">
        <h2 class="text-center mb-4">Your Orders</h2>
        <div class="row">
            <% 
            List<Order> orders = (List<Order>) request.getAttribute("orders");
            if (orders != null && !orders.isEmpty()) {
                for (Order order : orders) { %>
                    <div class="col-md-12">
                        <div class="order-item">
                            <h3>Order ID: <%= order.getId() %></h3>
                            <p>Date: <%= order.getOrderDate() %></p>
                            <p>Total Amount: $<%= order.getTotalAmount() %></p>
                            <h4>Items:</h4>
                            <ul>
                                <% List<OrderDetail> orderDetails = order.getOrderDetails();
                                if (orderDetails != null && !orderDetails.isEmpty()) {
                                    for (OrderDetail detail : orderDetails) { %>
                                        <li>
                                            <%-- Fetch the food item details --%>
                                            Item ID: <%= detail.getFoodItemId() %> - Quantity: <%= detail.getQuantity() %> - Price: $<%= detail.getPrice() %>
                                        </li>
                                    <% }
                                } else { %>
                                    <li>No items in this order.</li>
                                <% } %>
                            </ul>
                        </div>
                    </div>
                <% }
            } else { %>
                <div class="col">
                    <p>No orders available.</p>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>
