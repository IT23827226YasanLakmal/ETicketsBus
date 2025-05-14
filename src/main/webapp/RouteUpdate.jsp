<%@ page import="com.eBusTicketsWeb.model.Route" %>
<%@ page import="com.eBusTicketsWeb.model.RouteStop" %>
<%@ page import="java.util.List" %>
<%
    Route route = (Route) request.getAttribute("route");
    List<RouteStop> stops = (List<RouteStop>) request.getAttribute("stops");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Route</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
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
            max-width: 600px;
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

        .btn-danger {
            background-color: #d9534f;
            border-color: #d9534f;
            border-radius: 10px;
        }

        .btn-danger:hover {
            background-color: #c9302c;
            border-color: #c12e2a;
        }

        .stop-input-group {
            background-color: #e8f1f2;
            padding: 1rem;
            border-radius: 10px;
            margin-bottom: 1rem;
            border: 1px solid #9ad1d4;
        }

        .stop-label {
            color: #003249;
            font-weight: 500;
            margin-bottom: 0.5rem;
            display: block;
        }

        .input-row {
            display: flex;
            gap: 1rem;
            margin-bottom: 1rem;
        }

        .input-col {
            flex: 1;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h3 class="form-title">Update Route Details</h3>
    <form action="RouteUpdateServlet" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="route_id" value="<%= route.getId() %>">

        <div class="mb-3">
            <label for="start" class="form-label">Start Location</label>
            <input type="text" class="form-control" id="start" name="start" value="<%= route.getStart() %>" required>
        </div>

        <div class="mb-3">
            <label for="end" class="form-label">End Location</label>
            <input type="text" class="form-control" id="end" name="end" value="<%= route.getEnd() %>" required>
        </div>

        <div class="mb-3">
            <label for="distance_km" class="form-label">Distance (km)</label>
            <input type="number" step="0.01" min="1" class="form-control" id="distance_km" name="distance_km" value="<%= route.getDistance_km() %>" required>
        </div>

        <div id="stopInputs" class="mb-3">
            <label class="form-label">Stops</label>
            <% for (RouteStop stop : stops) { %>
                <div class="stop-input-group">
                    <input type="hidden" name="stop_ids" value="<%= stop.getId() %>">
                    <div class="input-row">
                        <div class="input-col">
                            <label class="stop-label">Stop Name</label>
                            <input type="text" class="form-control" name="stop_name" value="<%= stop.getStop_name()%>" required placeholder="Stop Name">
                        </div>
                        <div class="input-col">
                            <label class="stop-label">Stop Order</label>
                            <input type="number" class="form-control" name="stop_order" value="<%= stop.getStop_order() %>" min="1" required placeholder="Order">
                        </div>
                    </div>
                    <button type="button" class="btn btn-danger w-100" onclick="removeStopInput(this)">Remove Stop</button>
                </div>
            <% } %>
        </div>

        <div class="d-flex justify-content-between mb-3">
            <button type="button" class="btn btn-secondary" onclick="addStopInput()">Add More Stops</button>
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-primary w-100">Update Route Details</button>
        </div>
    </form>
</div>

<script>
    function addStopInput() {
        const div = document.getElementById("stopInputs");
        const stopGroup = document.createElement("div");
        stopGroup.classList.add("stop-input-group");
        
        const inputRow = document.createElement("div");
        inputRow.classList.add("input-row");
        
        // Name Column
        const nameCol = document.createElement("div");
        nameCol.classList.add("input-col");
        
        const nameLabel = document.createElement("label");
        nameLabel.classList.add("stop-label");
        nameLabel.innerText = "Stop Name";
        
        const nameInput = document.createElement("input");
        nameInput.type = "text";
        nameInput.classList.add("form-control");
        nameInput.name = "stop_name";
        nameInput.placeholder = "New Stop";
        nameInput.required = true;
        
        nameCol.appendChild(nameLabel);
        nameCol.appendChild(nameInput);
        
        // Order Column
        const orderCol = document.createElement("div");
        orderCol.classList.add("input-col");
        
        const orderLabel = document.createElement("label");
        orderLabel.classList.add("stop-label");
        orderLabel.innerText = "Stop Order";
        
        const orderInput = document.createElement("input");
        orderInput.type = "number";
        orderInput.classList.add("form-control");
        orderInput.name = "stop_order";
        orderInput.placeholder = "Order";
        orderInput.min = "1";
        orderInput.required = true;
        
        orderCol.appendChild(orderLabel);
        orderCol.appendChild(orderInput);
        
        // Add columns to row
        inputRow.appendChild(nameCol);
        inputRow.appendChild(orderCol);
        
        // Build the group
        stopGroup.appendChild(inputRow);
        
        div.appendChild(stopGroup);
    }

    function removeStopInput(button) {
        const stopGroup = button.closest('.stop-input-group');
        stopGroup.remove();
    }
    
    function validateForm() {
        const stopOrders = [];
        const orderInputs = document.querySelectorAll('input[name="stop_order"]');
        
        // Check for duplicates and sequential order
        for (let i = 0; i < orderInputs.length; i++) {
            const order = parseInt(orderInputs[i].value);
            
            if (isNaN(order) || order < 1) {
                alert("Stop order must be a number greater than 0");
                return false;
            }
            
            if (stopOrders.includes(order)) {
                alert("Duplicate stop order found: " + order);
                return false;
            }
            stopOrders.push(order);
        }
        
        // Check if orders are sequential starting from 1
        const sortedOrders = [...stopOrders].sort((a, b) => a - b);
        for (let i = 0; i < sortedOrders.length; i++) {
            if (sortedOrders[i] !== i + 1) {
                alert("Stop orders must be sequential starting from 1");
                return false;
            }
        }
        
        return true;
    }
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
