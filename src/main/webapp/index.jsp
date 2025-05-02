<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>eBusTicket System - Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background: linear-gradient(to right, #00c6ff, #0072ff);
            color: #fff;
            font-family: 'Segoe UI', sans-serif;
        }
        .hero-section {
            padding: 80px 0;
            text-align: center;
        }
        .hero-section h1 {
            font-size: 48px;
            font-weight: bold;
        }
        .hero-section p {
            font-size: 18px;
            margin: 20px 0 40px;
        }
        .btn-custom {
            background-color: #fff;
            color: #0072ff;
            font-weight: bold;
            padding: 10px 25px;
            border-radius: 30px;
            border: none;
            transition: all 0.3s ease;
        }
        .btn-custom:hover {
            background-color: #0072ff;
            color: #fff;
            border: 2px solid #fff;
        }
        footer {
            background-color: #005cbf;
            padding: 15px 0;
            text-align: center;
            margin-top: 80px;
            bottom:0;
            position:fixed;
            width:100%;	
        }
    </style>
</head>
<body>

<div class="hero-section">
    <div class="container">
        <h1>Welcome to eBusTicket System</h1>
        <p>Book your bus tickets anytime, anywhere. Fast. Easy. Reliable.</p>
        <a href="login.jsp" class="btn btn-custom mr-2">Login</a>
        <a href="register.jsp" class="btn btn-custom">Register</a>
    </div>
</div>

<footer>
    <div class="container">
        <p class="mb-0">&copy; 2025 eBusTicket System. All rights reserved.</p>
    </div>
</footer>

</body>
</html>