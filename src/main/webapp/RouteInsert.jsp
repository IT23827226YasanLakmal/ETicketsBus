<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Route Information Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow-lg rounded">
            <div class="card-body">
                <h3 class="card-title mb-4 text-center text-primary">Route Information Form</h3>
                <form action="RouteInsertServlet" method="post">
                    <div class="mb-3">
                        <label for="source" class="form-label">Source</label>
                        <input type="text" class="form-control" id="source" name="source" required>
                    </div>

                    <div class="mb-3">
                        <label for="destination" class="form-label">Destination</label>
                        <input type="text" class="form-control" id="destination" name="destination" required>
                    
                    </div>

                    <div class="d-flex align-items-center">
                        <label for="distance_km" class="me-3 mb-0">Distance (km):</label>
                         <input type="number" step="0.01" class="form-control  w-auto" id="distance_km" name="distance_km" min="1" step="1" required>
                    </div>
                    
                    <div class="mb-3">
                        <label for="stops" class="form-label">Stops</label>
                        <input type="text" class="form-control" id="stops" name="stops" required>
                    </div>

                    <div class="d-flex align-items-center">
                         <label class="me-3">Estimated Time:</label>
                             <div class="d-flex gap-2">
                             <input type="number" class="form-control" name="hh" min="0" max="23" placeholder="HH" required>
                             <input type="number" class="form-control" name="mm" min="0" max="59" placeholder="MM" required>
                             <input type="number" class="form-control" name="ss" min="0" max="59" placeholder="SS" required>
                    </div>
       </div>

                    <div class=" mt-3  text-center">
                        <button type="submit" class="btn btn-primary">Submit Route</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS Bundle -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
