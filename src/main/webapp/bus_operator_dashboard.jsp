<%@ page import="java.util.*, java.text.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    String staffName = (String) session.getAttribute("staffName");
    if (staffName == null) {
%>
    <script>
        alert("Session expired!!.Please log in again.");//Prevent users directly access bus_operator_dashboard page by url
        window.location.href = "staffLogin.jsp";
    </script>
<%
        return;
    }
%>


<!DOCTYPE html>
<html>
<head>
    <title>Bus Operator - Update Bus Schedule</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="bg-light">

<div class="container mt-3 d-flex justify-content-end align-items-center gap-3">
    <div class="text-muted">Welcome, <%= session.getAttribute("staffName") %></div>
    <form action="stafflogoutServlet" method="post" class="m-0">
        <button type="submit" class="btn btn-sm btn-outline-danger">Logout</button>
    </form>
</div>



<!-- Check if the busIds are not present and redirect to the servlet -->
<c:if test="${empty allbusIds}">
    <c:redirect url="getallSchedule"/>
</c:if>

<div class="container mt-5">
    <h2 class="text-center mb-4">Bus Schedule Management</h2>

    <!-- Schedule Form -->
    <div class="card mb-4 shadow">
        <div class="card-header bg-primary text-white">Add / Update Schedule</div>
        <div class="card-body">
            <form action="scheduleServlet" method="post">
                <div class="row g-3">
                    <!--  <div class="col-md-3">
                        <label>Schedule ID</label>
                        <input type="text" name="scheduleId" class="form-control" required>
                    </div>-->
                    
                    
                    <div class="col-md-4 mb-3">
    	<label>Bus ID</label>
    	<select name="busId" class="form-select" required>
        <option value="">-- Select Bus ID --</option>
        <c:forEach var="bus" items="${allbusIds}">
            <option value="${bus.busId}">${bus.busId}</option>
        </c:forEach>
    </select>
</div>

                    
                    
                    <div class="col-md-4 mb-3">
    	<label>Route ID</label>
    	<select name="routeId" class="form-select" required>
        <option value="">-- Select Route ID --</option>
        <c:forEach var="route" items="${allrouteIds}">
            <option value="${route.routeId}">${route.routeId}</option>
        </c:forEach>
    </select>
</div>
                    
                    
                   <div class="col-md-4 mb-3">
    	<label>Driver ID</label>
    	<select name="driverId" class="form-select" required>
        <option value="">-- Select Driver ID --</option>
        <c:forEach var="driver" items="${alldriverIds}">
            <option value="${driver.driverId}">${driver.driverId}</option>
        </c:forEach>
    </select>
</div> 
               
                    <div class="col-md-4 mb-3">
                        <label>Departure Time</label>
                        <input type="time" name="departureTime" class="form-control" required>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Arrival Time</label>
                        <input type="time" name="arrivalTime" class="form-control" required>
                    </div>
                    <div class="col-md-4 mb-3">
                        <label>Travel Date</label>
                        <input type="date" name="travelDate" class="form-control" required>
                    </div>
                    <!--  <div class="col-md-3">
                        <label>Fare</label>
                        <input type="number" step="0.01" name="fare" class="form-control" required>
                    </div>-->
                </div>
                <div class="mt-4 d-flex justify-content-center">
                    <button type="submit" name="action" value="create" class="btn btn-success px-5">Add</button>
                   <!--   <button type="submit" name="action" value="update" class="btn btn-warning">Update</button>-->
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
                    <!--  <th>Fare</th>-->
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%-- Sample static data for demo purposes. Replace with dynamic content from DB --%>
                <c:forEach var="allsc" items="${allSchedules}">
                
                <tr>
                    <td>${allsc.id}</td>
                    <td>${allsc.busId}</td>
                    <td>${allsc.routeId}</td>
                    <td>${allsc.driverId}</td>
                    <td>${allsc.departure}</td>
                    <td>${allsc.arrival}</td>
                    <td>${allsc.travelDate}</td>
                    <%--   <td>${allsc.fare}</td>--%>
                    <td>
                        <!--  <form action="scheduleServlet" method="post" style="display:inline;">
                            <input type="hidden" name="scheduleId" value="101"/>
                            -->
                            <a href="UpdateScheduleFormServlet?id=${allsc.id}&bus=${allsc.busId}&route=${allsc.routeId}&driver=${allsc.driverId}&departure=${allsc.departure}&arrival=${allsc.arrival}&date=${allsc.travelDate}" class="btn btn-sm btn-info">
   							Edit
							</a>
                        <!-- </form> -->
                        <form action="deleteScheduleServlet" method="post" style="display:inline;" onsubmit="return confirmDelete();">
                            <input type="hidden" name="scheduleId" value="${allsc.id}"/>
                            <button name="action" value="delete" class="btn btn-sm btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
                
            </table>
        </div>
    </div>
</div>
<script>
    function confirmDelete() {
        return confirm("Are you sure you want to delete this schedule?");
    }
</script>

</body>
</html>
