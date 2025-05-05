<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Bus Operator - Update Bus Schedule</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-5">
    <h2 class="text-center mb-4">Bus Schedule Management</h2>

    <!-- Schedule Form -->
    <div class="card mb-4 shadow">
        <div class="card-header bg-primary text-white">Add / Update Schedule</div>
        <div class="card-body">
            <form action="ScheduleServlet" method="post">
                <div class="row g-3">
                    <div class="col-md-3">
                        <label>Schedule ID</label>
                        <input type="text" name="scheduleId" class="form-control" required>
                    </div>
                    <div class="col-md-3">
                        <label>Bus ID</label>
                        <input type="text" name="busId" class="form-control" required>
                    </div>
                    <div class="col-md-3">
                        <label>Route ID</label>
                        <input type="text" name="routeId" class="form-control" required>
                    </div>
                    <div class="col-md-3">
                        <label>Driver ID</label>
                        <input type="text" name="driverId" class="form-control" required>
                    </div>
                    <div class="col-md-3">
                        <label>Departure Time</label>
                        <input type="time" name="departureTime" class="form-control" required>
                    </div>
                    <div class="col-md-3">
                        <label>Arrival Time</label>
                        <input type="time" name="arrivalTime" class="form-control" required>
                    </div>
                    <div class="col-md-3">
                        <label>Travel Date</label>
                        <input type="date" name="travelDate" class="form-control" required>
                    </div>
                    <div class="col-md-3">
                        <label>Fare</label>
                        <input type="number" step="0.01" name="fare" class="form-control" required>
                    </div>
                </div>
                <div class="mt-4">
                    <button type="submit" name="action" value="create" class="btn btn-success">Add</button>
                    <button type="submit" name="action" value="update" class="btn btn-warning">Update</button>
                </div>
            </form>
        </div>
    </div>

    <!-- Schedule Table -->
    <div class="card shadow">
        <div class="card-header bg-secondary text-white">Existing Schedules</div>
        <div class="card-body">
            <table class="table table-striped table-bordered text-center">
                <thead class="table-dark">
                <tr>
                    <th>Schedule ID</th>
                    <th>Bus ID</th>
                    <th>Route ID</th>
                    <th>Driver ID</th>
                    <th>Departure</th>
                    <th>Arrival</th>
                    <th>Date</th>
                    <th>Fare</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%-- Sample static data for demo purposes. Replace with dynamic content from DB --%>
                <tr>
                    <td>101</td>
                    <td>BUS001</td>
                    <td>RT005</td>
                    <td>DRV009</td>
                    <td>08:00</td>
                    <td>12:00</td>
                    <td>2025-05-06</td>
                    <td>$15.00</td>
                    <td>
                        <form action="ScheduleServlet" method="post" style="display:inline;">
                            <input type="hidden" name="scheduleId" value="101"/>
                            <button name="action" value="edit" class="btn btn-sm btn-info">Edit</button>
                        </form>
                        <form action="ScheduleServlet" method="post" style="display:inline;">
                            <input type="hidden" name="scheduleId" value="101"/>
                            <button name="action" value="delete" class="btn btn-sm btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
                <%-- Loop through your schedule list and display here --%>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
