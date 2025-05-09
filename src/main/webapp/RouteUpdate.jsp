<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Route Update Form</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    String source = request.getParameter("source");
    String destination = request.getParameter("destination");
    float distance_km = Float.parseFloat(request.getParameter("distance_km"));
    String stops = request.getParameter("stops");
    String estimated_time = request.getParameter("estimated_time");

    String hh = "00", mm = "00", ss = "00";
    if (estimated_time != null && estimated_time.contains(":")) {
        String[] timeParts = estimated_time.split(":");
        hh = timeParts.length > 0 ? timeParts[0] : "00";
        mm = timeParts.length > 1 ? timeParts[1] : "00";
        ss = timeParts.length > 2 ? timeParts[2] : "00";
    }
%>

    <div class="container mt-5">
        <div class="card shadow-lg rounded">
            <div class="card-body">
                <h3 class="card-title mb-4 text-center text-primary">Update Route Details</h3>
                <form action="RouteUpdateServlet" method="post">
                <div class="mb-3">
                        <label for="id" class="form-label">ID:</label>
                        <input type="text" class="form-control" id="source" name="id" value="<%=id%>" readonly>
                    </div>
                    <div class="mb-3">
                        <label for="source" class="form-label">Source:</label>
                        <input type="text" class="form-control" id="source" name="source" value="<%=source%>" required>
                    </div>

                    <div class="mb-3">
                        <label for="destination" class="form-label">Destination:</label>
                        <input type="text" class="form-control" id="destination" name="destination" value="<%=destination%>" required>
                    </div>

                    <div class="d-flex align-items-center">
                        <label for="distance_km" class="me-3 mb-0">Distance (km):</label>
                         <input type="number" step="0.01" class="form-control  w-auto" id="distance_km" name="distance_km" value="<%=distance_km%>" min="1" step="1" required>
                    </div>

                    <div class="mb-3">
                        <label for="stops" class="form-label">Stops:</label>
                        <input type="text" class="form-control" id="stops" name="stops"value="<%=stops%>" required>
                    </div>

                   <div class="d-flex align-items-center">
                         <label class="me-3">Estimated Time:</label>
                             <div class="d-flex gap-2">
                             <input type="number" class="form-control" name="hh" min="0" max="23" placeholder="HH" value="<%=hh%>" required>
                             <input type="number" class="form-control" name="mm" min="0" max="59" placeholder="MM" value="<%=mm%>" required>
                             <input type="number" class="form-control" name="ss" min="0" max="59" placeholder="SS" value="<%=ss%>" required>
                    </div>
            </div>
                    <div class="mt-3  text-center">
                        <button type="submit" class="btn btn-primary">Submit Changes:</button>
                    </div>
                </form>
            </div>
        </div>
    </div> 

 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>