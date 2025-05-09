<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Book Your Bus</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
  <style>
    .hero {
      background: linear-gradient(135deg, #0d6efd, #6610f2);
      color: white;
      padding: 60px 0;
      text-align: center;
      border-radius: 12px;
      margin-bottom: 40px;
    }
    .form-card {
      background-color: #ffffff;
      border-radius: 12px;
      box-shadow: 0 4px 10px rgba(0, 0, 0, 0.05);
      padding: 25px;
    }
  </style>
</head>
<body>

  <%@ include file="user_navbar.jsp" %>

  <div class="container mt-4">
   
    <c:if test="${not empty busList}">
      <div class="mb-5">
        <h4 class="mb-3"><i class="bi bi-calendar-check me-2"></i>Available Buses</h4>
        <div class="row row-cols-1 row-cols-md-2 g-4">
          <c:forEach var="bus" items="${busList}">
              <div class="card shadow-sm h-100 border-0">
                <div class="card-body">
                  <h5 class="card-title text-primary">
                    <i class="bi bi-geo-alt-fill"></i> ${bus.busType} 
                  </h5>
                  <p class="mb-2"><i class="bi "></i> Date: <strong>${bus.totalSeats}</strong></p>
                  <p class="mb-1"><i class="bi "></i> Departure: <strong>${bus.busNumber}</strong></p>
                  
                 <form action="viewAllBus/seat" method="post">
                    <input name="busId" type="hidden" id="busId" value="${bus.id}">
                    <input name="busType" type="hidden" id="busType" value="${bus.busType}">
                    <input name="busNumber" type="hidden" id="busNumber" value="${bus.busNumber}">
                    <button type="submit" class="btn btn-outline-primary btn-sm"> <i class="bi bi-ticket-perforated me-1"></i>Book Now</button>
                   </form>
                   
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </c:if>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
