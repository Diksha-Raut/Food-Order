<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.dk.entity.FoodItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .menu-container {
            max-width: 800px;
            margin: 0 auto;
        }
        .menu-item {
            margin-bottom: 20px;
            background-color: #fff;
            padding: 15px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
        .menu-item h3 {
            margin-bottom: 10px;
        }
        .menu-item .btn-add-to-cart {
            float: right;
        }
        .form-group {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>
    <div class="container menu-container">
        <h2 class="text-center mb-4">Menu</h2>
        <div class="row">
            <% 
            List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");
            if (foodItems != null && !foodItems.isEmpty()) {
                for (FoodItem item : foodItems) { %>
                    <div class="col-md-6">
                        <div class="menu-item">
                            <h3><%= item.getName() %></h3>
                            <p><%= item.getDescription() %></p>
                            <p>Price: $<%= item.getPrice() %></p>
                            <form action="order" method="post">
                                <input type="hidden" name="foodItemId" value="<%= item.getId() %>">
                                <div class="form-group">
                                    <label for="quantity_<%= item.getId() %>">Quantity:</label>
                                    <input type="number" id="quantity_<%= item.getId() %>" name="quantity" value="1" min="1" class="form-control">
                                </div>
                                <button type="submit" class="btn btn-success btn-add-to-cart">Add to Cart</button>
                            </form>
                        </div>
                    </div>
                <% }
            } else { %>
                <div class="col">
                    <p>No food items available.</p>
                </div>
            <% } %>
        </div>
    </div>
    <!-- Bootstrap JS and dependencies -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
