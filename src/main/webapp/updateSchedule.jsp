<%@ page import="java.util.*, java.text.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Schedule</title>
    <!-- ✅ Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<%
    int id = Integer.parseInt(request.getParameter("id"));
    int busId = Integer.parseInt(request.getParameter("bus"));
    int routeId = Integer.parseInt(request.getParameter("route"));
    int driverId = Integer.parseInt(request.getParameter("driver"));
    String depStr = request.getParameter("departure");
    String arrStr = request.getParameter("arrival");
    String dateStr = request.getParameter("date");
    double fare = Double.parseDouble(request.getParameter("fare"));
%>

<div class="container mt-5">
    <h2 class="text-center mb-4">Bus Schedule Management</h2>

    <!-- Schedule Form -->
    <div class="card shadow">
        <div class="card-header bg-primary text-white">Update Schedule</div>
        <div class="card-body">
            <form action="updatescheduleServlet" method="post">
                <div class="row g-3">
                    <div class="col-md-3">
                        <label>Schedule ID</label>
                        <input type="text" name="scheduleId" class="form-control" value="<%=id%>" readonly>
                    </div>
                    <div class="col-md-3">
                        <label>Bus ID</label>
                        <input type="text" name="busId" class="form-control" value="<%=busId%>" required>
                    </div>
                    <div class="col-md-3">
                        <label>Route ID</label>
                        <input type="text" name="routeId" class="form-control" value="<%=routeId%>" required>
                    </div>
                    <div class="col-md-3">
                        <label>Driver ID</label>
                        <input type="text" name="driverId" class="form-control" value="<%=driverId%>" required>
                    </div>
                    <div class="col-md-3">
                        <label>Departure Time</label>
                        <input type="time" name="departureTime" class="form-control" value="<%=depStr%>" required>
                    </div>
                    <div class="col-md-3">
                        <label>Arrival Time</label>
                        <input type="time" name="arrivalTime" class="form-control" value="<%=arrStr%>" required>
                    </div>
                    <div class="col-md-3">
                        <label>Travel Date</label>
                        <input type="date" name="travelDate" class="form-control" value="<%=dateStr%>" required>
                    </div>
                    <div class="col-md-3">
                        <label>Fare</label>
                        <input type="number" step="0.01" name="fare" class="form-control" value="<%=fare%>" required>
                    </div>
                </div>
                <div class="mt-4 d-flex justify-content-center">
                    <button type="submit" name="action" value="update" class="btn btn-warning px-4">Update</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- ✅ Bootstrap JS (optional for interactivity) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
