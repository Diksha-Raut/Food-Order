<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Ordering App</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            padding-top: 100px;
            text-align: center;
        }
        .menu-links {
            margin-top: 50px;
        }
        .menu-links a {
            margin: 10px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Food Ordering App</h1>
        <p class="lead">Order your favorite meals from our wide selection of delicious dishes!</p>
        
        <div class="menu-links">
            <a href="login.jsp" class="btn btn-primary">Login</a>
            <a href="register.jsp" class="btn btn-primary">Register</a>
            <a href="menu" class="btn btn-success">View Menu</a>
        </div>
    </div>
</body>
</html>
