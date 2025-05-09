<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Route List</title>
<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Route List</h2>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Source</th>
                <th>Destination</th>
                <th>Distance (km)</th>
                <th>Stops</th>
                <th>Estimated Time</th>
                 <th>Action</th>
            </tr>
        </thead>
        <tbody>
         <c:forEach var="route" items="${allRoutes}">
         <tr>
         <td>${route.id}</td>
         <td>${route.source}</td>
         <td>${route.destination}</td>
         <td>${route.distance_km} </td>
         <td>${route.stops}</td>
         <td>${route.estimated_time} </td>
         <td>
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Manage
                        </button>
                        <ul class="dropdown-menu">
                            <li>
                            <a class="dropdown-item" href="RouteUpdate.jsp?id=${route.id}&source=${route.source}&destination=${route.destination}&distance_km=${route.distance_km}&stops=${route.stops}&estimated_time=${route.estimated_time}">
                            Update
                            </a>
                            </li>
                            <li>
                               <form action="RouteDeleteServlet" method="post" onsubmit="return confirm('Are you sure you want to delete this route?');">
                                     <input type="hidden" name="id" value="${route.id}" />
                                          <button type="submit" class="dropdown-item text-danger">Delete</button>
                               </form>
                            </li>
                        </ul>
                    </div>
                </td>
          </tr>
          </c:forEach>
          </tbody>
    </table>
</div>
<div class="mt-3 text-center">
    <a href="RouteInsert.jsp" class="btn btn-primary">Insert New Route</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>