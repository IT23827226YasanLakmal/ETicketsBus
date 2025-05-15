<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>About Us | E-Bus Tickets</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #007ea7, #003249);
            min-height: 100vh;
        }
        .nav-pills .nav-link.active {
            background-color: #007ea7;
        }
        .bg-custom {
            background-color: #ccdbdc;
        }
        .text-custom {
            color: #003249;
        }
        .feature-icon {
            font-size: 2rem;
            color: #007ea7;
            margin-bottom: 1rem;
        }
    </style>
</head>
<body>
<div class="container py-4">
    <!-- Header -->
    <div class="d-flex justify-content-between align-items-center bg-custom p-3 rounded mb-4">
        <h1 class="h4 mb-0 text-custom">E-Bus Tickets</h1>
        <div class="d-flex align-items-center">
            <span class="me-2"><i class="bi bi-person-circle"></i></span>
            <span class="text-custom">Admin</span>
        </div>
    </div>

    <!-- Navigation -->
    <ul class="nav nav-pills bg-custom p-2 rounded mb-4">
        <li class="nav-item">
            <a class="nav-link text-custom" href="admin-dashboard.jsp">
                <i class="bi bi-house-door me-1"></i> Home
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="#">
                <i class="bi bi-info-circle me-1"></i> About Us
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-custom" href="#">
                <i class="bi bi-telephone me-1"></i> Contact
            </a>
        </li>
    </ul>

    <!-- About Content -->
    <div class="bg-custom p-4 rounded mb-4">
        <h2 class="text-custom mb-4">
            <i class="bi bi-bus-front me-2"></i>About Our Service
        </h2>
        <div class="row">
            <div class="col-md-12">
                <p class="lead text-custom">
                    <i class="bi bi-stars me-2"></i>We provide the easiest way to book bus tickets online.
                </p>
                <p class="text-custom">
                    <i class="bi bi-check-circle me-2"></i>Our platform connects travelers with bus operators across the country.
                </p>
                <p class="text-custom">
                    <i class="bi bi-check-circle me-2"></i>Offering real-time availability, secure payments, and 24/7 customer support.
                </p>
            </div>
        </div>
    </div>

    <!-- Features with Tooltips -->
    <div class="bg-custom p-4 rounded mb-4">
        <h3 class="text-custom mb-4">
            <i class="bi bi-star-fill me-2"></i>Why Choose Us
        </h3>
        <div class="row text-center">
            <div class="col-md-4 mb-3">
                <div class="p-3 rounded" style="background-color: #e8f1f2;">
                    <i class="bi bi-ticket-perforated feature-icon"></i>
                    <h5 class="text-custom">Easy Booking</h5>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="p-3 rounded" style="background-color: #e8f1f2;">
                    <i class="bi bi-geo-alt feature-icon"></i>
                    <h5 class="text-custom">Live Tracking</h5>
                </div>
            </div>
            <div class="col-md-4 mb-3">
                <div class="p-3 rounded" style="background-color: #e8f1f2;">
                    <i class="bi bi-headset feature-icon"></i>
                    <h5 class="text-custom">24/7 Support</h5>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="bg-custom p-3 rounded text-center">
        <p class="mb-0 text-custom">
            <i class="bi bi-c-circle me-1"></i>2023 E-Bus Tickets. All rights reserved.
        </p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Initialize Bootstrap tooltips
    document.addEventListener('DOMContentLoaded', function() {
        const featureItems = document.querySelectorAll('.feature-icon');
        
        featureItems.forEach((item, index) => {
            const tooltipText = [
                "Simple 3-step booking process",
                "Real-time bus location tracking",
                "Round-the-clock customer service"
            ];
            
            item.setAttribute('data-bs-toggle', 'tooltip');
            item.setAttribute('data-bs-placement', 'top');
            item.setAttribute('title', tooltipText[index]);
            
            new bootstrap.Tooltip(item);
        });
    });
</script>
</body>
</html>