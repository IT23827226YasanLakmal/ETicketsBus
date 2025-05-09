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
    <div class="hero">
      <h1><i class="bi bi-bus-front-fill me-2"></i>Book Your Bus</h1>
      <p class="lead">Find your next ride quickly and easily.</p>
    </div>

    <div class="form-card mb-5">
      <h4 class="mb-4"><i class="bi bi-search me-2"></i>Search for a Bus</h4>
      <form action="searchTicket" method="post" class="row g-3">
        <div class="col-md-4">
          <label for="from" class="form-label">From</label>
          <input name="from" type="text" class="form-control" id="from" placeholder="Start Location" required>
        </div>
        <div class="col-md-4">
          <label for="to" class="form-label">To</label>
          <input name="to" type="text" class="form-control" id="to" placeholder="Destination" required>
        </div>
        <div class="col-md-4">
          <label for="date" class="form-label">Date</label>
          <input name="date" type="date" class="form-control" id="date" required>
        </div>
        <div class="col-12 text-end">
          <button type="submit" class="btn btn-primary px-4"><i class="bi bi-arrow-right-circle me-1"></i>Search</button>
        </div>
      </form>
    </div>

    <c:if test="${not empty scheduleList}">
      <div class="mb-5">
        <h4 class="mb-3"><i class="bi bi-calendar-check me-2"></i>Available Buses</h4>
        <div class="row row-cols-1 row-cols-md-2 g-4">
          <c:forEach var="schedule" items="${scheduleList}">
            <div class="col">
              <div class="card shadow-sm h-100 border-0">
                <div class="card-body">
                  <h5 class="card-title text-primary">
                    <i class="bi bi-geo-alt-fill"></i> ${schedule.start} <i class="bi bi-arrow-right-short"></i> ${schedule.end}
                  </h5>
                  <p class="mb-2"><i class="bi bi-calendar-event"></i> Date: <strong>${schedule.travelDate}</strong></p>
                  <p class="mb-1"><i class="bi bi-clock-fill"></i> Departure: <strong>${schedule.departureTime}</strong></p>
                  <p class="mb-3"><i class="bi bi-clock-history"></i> Arrival: <strong>${schedule.arrivalTime}</strong></p>
                
                  
                   <form action="viewAllBus" method="post">
                    <input name="scheduleId" type="hidden" id="scheduleId" value="${schedule.id}">
                    <input name="travelDate" type="hidden" id="travelDate" value="${schedule.travelDate}">
                    <input name="departureTime" type="hidden" id="departureTime" value="${schedule.departureTime}">
                    <input name="arrivalTime" type="hidden" id="arrivalTime" value="${schedule.arrivalTime}">
                    <button type="submit" class="btn btn-outline-primary btn-sm"> <i class="bi bi-ticket-perforated me-1"></i>Go To Booking</button>
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
