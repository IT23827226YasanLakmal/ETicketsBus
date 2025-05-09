<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Book Your Bus</title>
  <!-- Bootstrap 5 CSS -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

  <div class="container mt-5">
    <h2 class="mb-4">Book Your Bus</h2>

    <form action="searchResults.jsp" method="post" class="row g-3">
      <div class="col-md-4">
        <label for="from" class="form-label">From</label>
        <input name="from" type="text" class="form-control" id="from" required>
      </div>
      <div class="col-md-4">
        <label for="to" class="form-label">To</label>
        <input name="to" type="text" class="form-control" id="to" required>
      </div>
      <div class="col-md-4">
        <label for="date" class="form-label">Date</label>
        <input name="date" type="date" class="form-control" id="date" required>
      </div>
      <div class="col-12">
        <button type="submit" class="btn btn-primary">Search</button>
      </div>
    </form>

    <c:if test="${not empty busList}">
      <div class="mt-5">
        <h4>Available Buses</h4>
        <ul class="list-group">
          <c:forEach var="bus" items="${busList}">
            <li class="list-group-item d-flex justify-content-between align-items-center">
              <span>${bus.name}</span>
              <span class="badge bg-secondary">${bus.time}</span>
            </li>
          </c:forEach>
        </ul>
      </div>
    </c:if>
    
  </div>

  <!-- Bootstrap 5 JS Bundle -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
