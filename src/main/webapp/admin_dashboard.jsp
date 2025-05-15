<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>E-Bus Tickets Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #007ea7, #003249);
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
            color: #003249;
        }

        .header-container {
            background-color: #ccdbdc;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 1rem 2rem;
            margin-bottom: 1.5rem;
        }

        .navbar {
            background-color: #ccdbdc;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.1);
            padding: 0.5rem 1rem;
            margin-bottom: 2rem;
        }

        .nav-link {
            color: #003249;
            font-weight: 500;
            padding: 0.5rem 1rem;
            border-radius: 10px;
            transition: all 0.3s ease;
            margin: 0 0.25rem;
        }

        .nav-link:hover, .nav-link.active {
            background-color: #007ea7;
            color: white;
            transform: scale(1.05);
        }

        .dashboard-tab {
            display: flex;
            flex-direction: column;
            align-items: center;
            background-color: #ccdbdc;
            border: 2px solid #9ad1d4;
            border-radius: 15px;
            padding: 1.5rem 1rem;
            color: #003249;
            text-decoration: none;
            font-weight: 500;
            transition: all 0.3s ease;
            height: 100%;
            box-shadow: 0 5px 10px rgba(0, 0, 0, 0.05);
        }

        .dashboard-tab:hover {
            background-color: #9ad1d4;
            transform: translateY(-5px);
            box-shadow: 0 8px 15px rgba(0, 0, 0, 0.1);
        }

        .icon-circle {
            width: 70px;
            height: 70px;
            border-radius: 50%;
            background-color: #007ea7;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto 15px;
            color: white;
            font-size: 30px;
            transition: all 0.3s ease;
        }

        .dashboard-tab:hover .icon-circle {
            background-color: #003249;
            transform: scale(1.1);
        }

        .admin-name {
            color: #007ea7;
            font-weight: 600;
        }

        .page-title {
            color: #003249;
            font-weight: 700;
        }
    </style>
</head>
<body>
<div class="container py-4">
    <!-- Header -->
    <div class="header-container d-flex justify-content-between align-items-center">
        <h1 class="page-title h4 mb-0">E-Bus Tickets Admin Dashboard</h1>
        <div class="d-flex align-items-center">
            <i class="bi bi-person-circle me-2" style="font-size: 1.5rem; color: #007ea7;"></i>
            <span>Admin: <span class="admin-name">Name</span></span>
        </div>
    </div>

    <!-- Navigation Bar-->
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="#" style="color: #003249;">Admin Panel</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link active" href="#"><i class="bi bi-house-door me-1"></i> Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-info-circle me-1"></i> About Us</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-question-circle me-1"></i> Help</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-envelope me-1"></i> Contact Us</a></li>
                    <li class="nav-item"><a class="nav-link" href="#"><i class="bi bi-patch-question me-1"></i> FAQ</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Dashboard Tabs -->
    <div class="row g-4 justify-content-center">
        <div class="col-md-6 col-lg-4">
            <a href="#" class="dashboard-tab">
                <div class="icon-circle"><i class="bi bi-calendar3"></i></div>
                Schedules
            </a>
        </div>
        <div class="col-md-6 col-lg-4">
            <a href="#" class="dashboard-tab">
                <div class="icon-circle"><i class="bi bi-bus-front-fill"></i></div>
                Buses
            </a>
        </div>
        <div class="col-md-6 col-lg-4">
            <a href="#" class="dashboard-tab"> 
                <div class="icon-circle"><i class="bi bi-person-badge-fill"></i></div>
                Staff
            </a>
        </div>
        <div class="col-md-6 col-lg-4">
            <a href="RouteReadServlet" class="dashboard-tab">
                <div class="icon-circle"><i class="bi bi-signpost-2-fill"></i></div>
                Routes
            </a>
        </div>
        <div class="col-md-6 col-lg-4">
            <a href="#" class="dashboard-tab">
                <div class="icon-circle"><i class="bi bi-people-fill"></i></div>
                Users
            </a>
        </div>
        <div class="col-md-6 col-lg-4">
            <a href="#" class="dashboard-tab">
                <div class="icon-circle"><i class="bi bi-chat-left-dots-fill"></i></div>
                Feedbacks
            </a>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
