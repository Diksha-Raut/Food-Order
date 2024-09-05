<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Confirmation</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
            padding-top: 50px;
        }
        .confirmation-container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0,0,0,0.1);
        }
        .confirmation-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .back-to-menu {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container confirmation-container">
        <h2>Order Confirmation</h2>
        <p>Your order has been placed successfully!</p>
        <div class="back-to-menu">
            <a href="menu" class="btn btn-primary">Back to Menu</a>
            <a href="logout" class="btn btn-primary">Logout</a>
            <a href="vieworder" class="btn btn-primary">View Order</a>
        </div>
    </div>
</body>
</html>
