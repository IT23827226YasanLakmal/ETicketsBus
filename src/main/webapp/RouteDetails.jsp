<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Route List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #007ea7, #003249);
            min-height: 100vh;
            font-family: 'Segoe UI', sans-serif;
            padding-top: 2rem;
            padding-bottom: 2rem;
        }

        .table-container {
            background-color: #ccdbdc;
            padding: 2rem;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 1200px;
            margin: 0 auto;
        }

        .table-title {
            text-align: center;
            font-weight: bold;
            color: #003249;
            margin-bottom: 1.5rem;
        }

        .table {
            border-radius: 10px;
            overflow: hidden;
        }

        .table th {
            background-color: #007ea7;
            color: white;
            font-weight: 500;
            border: none;
        }

        .table td {
            background-color: #e8f1f2;
            color: #003249;
            vertical-align: middle;
        }

        .table-hover tbody tr:hover td {
            background-color: #d4e6e7;
        }

        .btn-manage {
            background-color: #80ced7;
            border-color: #80ced7;
            color: #003249;
            border-radius: 10px;
        }

        .btn-manage:hover {
            background-color: #9ad1d4;
            border-color: #9ad1d4;
        }

        .dropdown-item {
            color: #003249;
        }

        .dropdown-item:hover {
            background-color: #e8f1f2;
            color: #007ea7;
        }

        .btn-insert {
            background-color: #007ea7;
            border-color: #007ea7;
            border-radius: 10px;
            padding: 0.75rem 1.5rem;
            font-weight: 500;
            margin-top: 1.5rem;
        }

        .btn-insert:hover {
            background-color: #003249;
            border-color: #003249;
        }

        .action-cell {
            width: 150px;
        }

        .stop-item {
            margin-bottom: 0.25rem;
        }
    </style>
</head>
<body>

<div class="table-container">
    <h3 class="table-title">Route List</h3>

    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>Start Location</th>
                <th>End Location</th>
                <th>Distance (km)</th>
                <th>Stops (Ordered)</th>
                <th class="action-cell">Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="route" items="${allRoutes}">
                <tr>
                    <td>${route.id}</td>
                    <td>${route.start}</td>
                    <td>${route.end}</td>
                    <td>${route.distance_km}</td>
                    <td>
                        <c:forEach var="stop" items="${routeStopsMap[route.id]}">
                            <div class="stop-item">${stop.stop_order}. ${stop.stop_name}</div>
                        </c:forEach>
                    </td>
                    <td>
                        <div class="dropdown">
                            <button class="btn btn-manage dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Manage
                            </button>
                            <ul class="dropdown-menu">
                                <li>
                                    <a class="dropdown-item" href="RouteUpdateServlet?route_id=${route.id}">
                                        <i class="bi bi-pencil-square"></i> Update
                                    </a>
                                </li>
                                <li>
                                    <form action="RouteDeleteServlet" method="post" onsubmit="return confirm('Are you sure you want to delete this route?');">
                                        <input type="hidden" name="id" value="${route.id}" />
                                        <button type="submit" class="dropdown-item text-danger">
                                            <i class="bi bi-trash"></i> Delete
                                        </button>
                                    </form>
                                </li>
                            </ul>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="text-center">
        <a href="RouteInsert.jsp" class="btn btn-insert">
            <i class="bi bi-plus-circle"></i> Insert New Route
        </a>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
