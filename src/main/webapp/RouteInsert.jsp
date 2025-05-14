<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Route Information Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Internal CSS Styling -->
    <style>
        body {
            background: linear-gradient(135deg, #007ea7, #003249);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            font-family: 'Segoe UI', sans-serif;
        }

        .form-container {
            background-color: #ccdbdc;
            padding: 2rem;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 500px;
        }

        .form-title {
            text-align: center;
            font-weight: bold;
            color: #003249;
            margin-bottom: 1.5rem;
        }

        .form-label {
            color: #003249;
            font-weight: 500;
        }

        .form-control {
            border-radius: 10px;
            border: 1px solid #9ad1d4;
        }

        .form-control:focus {
            border-color: #007ea7;
            box-shadow: 0 0 5px rgba(0, 126, 167, 0.4);
        }

        .btn-primary {
            background-color: #007ea7;
            border-color: #007ea7;
            border-radius: 10px;
        }

        .btn-primary:hover {
            background-color: #003249;
            border-color: #003249;
        }

        .btn-secondary {
            background-color: #80ced7;
            border-color: #80ced7;
            color: #003249;
            border-radius: 10px;
        }

        .btn-secondary:hover {
            background-color: #9ad1d4;
            border-color: #9ad1d4;
        }
    </style>
</head>

<body>

    <div class="form-container">
        <h3 class="form-title">Route Information Form</h3>
        <form action="RouteInsertServlet" method="post">
            <div class="mb-3">
                <label for="start" class="form-label">Start Location</label>
                <input type="text" class="form-control" id="start" name="start" required>
            </div>

            <div class="mb-3">
                <label for="end" class="form-label">End Location</label>
                <input type="text" class="form-control" id="end" name="end" required>
            </div>

            <div class="mb-3">
                <label for="distance_km" class="form-label">Distance (km)</label>
                <input type="number" step="0.01" min="1" class="form-control" id="distance_km" name="distance_km" required>
            </div>

            <div id="stopInputs" class="mb-3">
                <label for="stop_name_1" class="form-label">Stop Name</label>
                <input type="text" class="form-control mb-2" name="stop_name" required>
            </div>

            <div class="d-flex justify-content-between mb-3">
                <button type="button" class="btn btn-secondary" onclick="addStopInput()">Add More Stops</button>
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-primary w-100">Submit Route Details</button>
            </div>
        </form>
    </div>

    <script>
        // Function to dynamically add stop name input fields
        function addStopInput() {
            const div = document.getElementById("stopInputs");
            const input = document.createElement("input");
            input.type = "text";
            input.name = "stop_name";
            input.placeholder = "Next Stop";
            input.classList.add("form-control", "mb-2");
            div.appendChild(input);
        }
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
