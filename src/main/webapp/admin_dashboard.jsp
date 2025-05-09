<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>E-Bus Tickets Admin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-4">
    <!-- Header -->
    <div class="d-flex justify-content-between align-items-center bg-primary text-white p-3 rounded">
        <h1 class="h3 mb-0">E-Bus Tickets</h1>
        <div>
            <i class="bi bi-person-circle"></i> Admin: <strong>Name</strong>
        </div>
    </div>

    <!-- Navigation Bar -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary mt-3 rounded">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">E-Bus Admin</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item"><a class="nav-link active" href="#">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">About Us</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Help</a></li>
                    <li class="nav-item"><a class="nav-link" href="#">Contact Us</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Dashboard Buttons -->
    <div class="row g-3 mt-4">
        <!-- Schedules -->
        <div class="col-md-6 mb-4">
            <div class="d-flex align-items-center">
                <div class="rounded-circle bg-white border border-primary border-end-0 d-flex align-items-center justify-content-center"
                     style="width: 70px; height: 70px; z-index: 2; position: relative;">
                    <img src="ScheduleIcon.png" alt="Schedules Icon" style="width: 24px; height: 24px;">
                </div>
                <a href="#" class="btn btn-outline-primary py-3 px-4 border-start-0 rounded-start-0"
                   style="margin-left: -15px; z-index: 1; position: relative;">Schedules</a>
            </div>
        </div>

        <!-- Buses -->
        <div class="col-md-6 mb-4">
            <div class="d-flex align-items-center">
                <div class="rounded-circle bg-white border border-primary border-end-0 d-flex align-items-center justify-content-center"
                     style="width: 70px; height: 70px; z-index: 2; position: relative;">
                    <img src="BusIcon.png" alt="Buses Icon" style="width: 24px; height: 24px;">
                </div>
                <a href="#" class="btn btn-outline-primary py-3 px-4 border-start-0 rounded-start-0"
                   style="margin-left: -15px; z-index: 1; position: relative;">Buses</a>
            </div>
        </div>

        <!-- Staff -->
        <div class="col-md-6 mb-4">
            <div class="d-flex align-items-center">
                <div class="rounded-circle bg-white border border-primary border-end-0 d-flex align-items-center justify-content-center"
                     style="width: 70px; height: 70px; z-index: 2; position: relative;">
                    <img src="StaffIcon.png" alt="Staff Icon" style="width: 24px; height: 24px;">
                </div>
                <a href="#" class="btn btn-outline-primary py-3 px-4 border-start-0 rounded-start-0"
                   style="margin-left: -15px; z-index: 1; position: relative;">Staff</a>
            </div>
        </div>

        <!-- Routes -->
        <div class="col-md-6 mb-4">
            <div class="d-flex align-items-center">
                <div class="rounded-circle bg-white border border-primary border-end-0 d-flex align-items-center justify-content-center"
                     style="width: 70px; height: 70px; z-index: 2; position: relative;">
                    <img src="RouteIcon.png" alt="Routes Icon" style="width: 24px; height: 24px;">
                </div>
                <a href="RouteReadServlet" class="btn btn-outline-primary py-3 px-4 border-start-0 rounded-start-0"
                   style="margin-left: -15px; z-index: 1; position: relative;">Routes</a>
            </div>
        </div>

        <!-- Users -->
        <div class="col-md-6 mb-4">
            <div class="d-flex align-items-center">
                <div class="rounded-circle bg-white border border-primary border-end-0 d-flex align-items-center justify-content-center"
                     style="width: 70px; height: 70px; z-index: 2; position: relative;">
                    <img src="UserIcon.png" alt="Users Icon" style="width: 24px; height: 24px;">
                </div>
                <a href="#" class="btn btn-outline-primary py-3 px-4 border-start-0 rounded-start-0"
                   style="margin-left: -15px; z-index: 1; position: relative;">Users</a>
            </div>
        </div>

        <!-- Feedbacks -->
        <div class="col-md-6 mb-4">
            <div class="d-flex align-items-center">
                <div class="rounded-circle bg-white border border-primary border-end-0 d-flex align-items-center justify-content-center"
                     style="width: 70px; height: 70px; z-index: 2; position: relative;">
                    <img src="FeedbackIcon.png" alt="Feedback Icon" style="width: 24px; height: 24px;">
                </div>
                <a href="#" class="btn btn-outline-primary py-3 px-4 border-start-0 rounded-start-0"
                   style="margin-left: -15px; z-index: 1; position: relative;">Feedbacks</a>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>