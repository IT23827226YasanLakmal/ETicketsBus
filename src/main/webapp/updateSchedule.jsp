<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Schedule</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-lg-10">
            <h2 class="text-center mb-4 text-primary">Update Bus Schedule</h2>

            <div class="card shadow">
                <div class="card-header bg-primary text-white fw-semibold">
                    Schedule Details
                </div>
                <div class="card-body">
                    <form action="updatescheduleServlet" method="post">
                        <div class="row g-4">
                            <div class="col-md-4">
                                <label class="form-label">Schedule ID</label>
                                <input type="text" name="scheduleId" class="form-control" value="${param.id}" readonly>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label">Bus ID</label>
                                <select name="busId" class="form-select" required>
                                    <option value="">-- Select Bus ID --</option>
                                    <c:forEach var="bus" items="${allbusIds}">
                                        <option value="${bus.busId}" <c:if test="${param.bus == bus.busId}">selected</c:if>>
                                            ${bus.busId}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label">Route ID</label>
                                <select name="routeId" class="form-select" required>
                                    <option value="">-- Select Route ID --</option>
                                    <c:forEach var="route" items="${allrouteIds}">
                                        <option value="${route.routeId}" <c:if test="${param.route == route.routeId}">selected</c:if>>
                                            ${route.routeId}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label">Driver ID</label>
                                <select name="driverId" class="form-select" required>
                                    <option value="">-- Select Driver ID --</option>
                                    <c:forEach var="driver" items="${alldriverIds}">
                                        <option value="${driver.driverId}" <c:if test="${param.driver == driver.driverId}">selected</c:if>>
                                            ${driver.driverId}
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>

                            <div class="col-md-4">
                                <label class="form-label">Departure Time</label>
                                <input type="time" name="departureTime" class="form-control" value="${param.departure}" required>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label">Arrival Time</label>
                                <input type="time" name="arrivalTime" class="form-control" value="${param.arrival}" required>
                            </div>
                            <div class="col-md-4">
                                <label class="form-label">Travel Date</label>
                                <input type="date" name="travelDate" class="form-control" value="${param.date}" required>
                            </div>
                        </div>

                        <div class="text-center mt-4">
                            <button type="submit" name="action" value="update" class="btn btn-warning px-5">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
