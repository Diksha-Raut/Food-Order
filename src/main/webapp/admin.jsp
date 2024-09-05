<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.dk.entity.FoodItem" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Manage Menu</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .admin-container {
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
        .add-food-item-form {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
            margin-top: 20px;
        }
        .add-food-item-form .btn-add-food-item {
            width: 100%;
        }
    </style>
</head>
<body>
    <div class="container admin-container">
        <h2 class="text-center mb-4">Admin - Manage Menu</h2>
        
        <div class="add-food-item-form">
            <h3>Add Food Item</h3>
            <form action="admin" method="post">
                <input type="hidden" name="action" value="add">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" id="name" name="name" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" id="description" name="description" class="form-control" required>
                </div>
                <div class="form-group">
                    <label for="price">Price</label>
                    <input type="text" id="price" name="price" class="form-control" required>
                </div>
                <button type="submit" class="btn btn-success btn-add-food-item">Add Food Item</button>
            </form>
        </div>

        <h3 class="mt-4">Current Menu</h3>
        <div class="row">
            <% List<FoodItem> foodItems = (List<FoodItem>) request.getAttribute("foodItems");
               if (foodItems != null && !foodItems.isEmpty()) {
                   for (FoodItem item : foodItems) { %>
                       <div class="col-md-6">
                           <div class="menu-item">
                               <h3><%= item.getName() %></h3>
                               <p><%= item.getDescription() %></p>
                               <p>Price: <%= item.getPrice() %></p>
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
</body>
</html>
