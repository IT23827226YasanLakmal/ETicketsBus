<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.eBusTicketsWeb.model.Seat" %>
<%@ page import="java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Bus Seat Selection</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f6f8;
            margin: 0;
            padding: 20px;
        }
        h2 {
            color: #333;
            text-align: center;
        }

        .bus-info-card {
            max-width: 600px;
            background: white;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
            margin: 0 auto 20px auto;
            padding: 20px;
        }

        .bus-info-card h3 {
            margin-top: 0;
            color: #1d3557;
            text-align: center;
        }

        .info-row {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
            border-bottom: 1px solid #eee;
        }
        .info-row:last-child {
            border-bottom: none;
        }
        .info-label {
            font-weight: bold;
            color: #333;
        }
        .info-value {
            color: #555;
        }

        #seatContainer {
            text-align: center;
            margin-bottom: 20px;
        }

        .seat {
            width: 40px;
            height: 40px;
            margin: 5px;
            background-color: #d9e2ec;
            border: 2px solid #486581;
            border-radius: 8px;
            display: inline-block;
            text-align: center;
            line-height: 40px;
            cursor: pointer;
            transition: all 0.3s ease;
            font-weight: bold;
            color: #102a43;
        }
        .seat:hover {
            background-color: #bcccdc;
        }
        .seat.selected {
            background-color: #2b9348;
            color: white;
            border-color: #1b7a34;
        }
        .seat.reserved {
            background-color: #e63946;
            color: white;
            cursor: not-allowed;
            border-color: #b02a37;
        }
        .seat.vip {
            border: 3px solid gold;
        }

        button {
            background-color: #457b9d;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            font-size: 16px;
            transition: background 0.3s ease;
        }
        button:hover {
            background-color: #1d3557;
        }

    </style>
</head>
<body>

<h2>Select Your Seats</h2>

<!-- ===== Bus Details Card ===== -->
<div class="bus-info-card">
    <h3>Bus Journey Details</h3>
    <div class="info-row">
        <div class="info-label">Travel Date:</div>
        <div class="info-value">${travelDate}</div>
    </div>
    <div class="info-row">
        <div class="info-label">Departure Time:</div>
        <div class="info-value">${departureTime}</div>
    </div>
    <div class="info-row">
        <div class="info-label">Arrival Time:</div>
        <div class="info-value">${arrivalTime}</div>
    </div>
    <div class="info-row">
        <div class="info-label">Bus Type:</div>
        <div class="info-value">${busType}</div>
    </div>
    <div class="info-row">
        <div class="info-label">Bus Number:</div>
        <div class="info-value">${busNumber}</div>
    </div>
</div>

<!-- ===== Seat Selection Form ===== -->
<form action="seat/book" method="post" id="seatForm">
    <div id="seatContainer">
        <c:forEach var="seat" items="${seatList}">
            <c:set var="cssClass" value="seat" />
            <c:if test="${seat.seatType == 'VIP'}">
                <c:set var="cssClass" value="${cssClass} vip" />
            </c:if>
            <c:if test="${seat.availability == 'RESERVED'}">
                <c:set var="cssClass" value="${cssClass} reserved" />
            </c:if>

            <div 
                class="${cssClass}" 
                data-seat-id="${seat.id}"
                title="Seat ${seat.seatNumber} (${seat.seatType})"
                <c:if test="${seat.availability == 'RESERVED'}">style="pointer-events: none;"</c:if> >
                ${seat.seatNumber}
            </div>
        </c:forEach>
    </div>

    <input type="hidden" name="selectedSeats" id="selectedSeats">
    
    <div style="text-align:center;">
        <button type="submit">Go To Payment</button>
    </div>
</form>

<script>
// Store selected seat IDs
const selectedSeatIds = new Set();

document.querySelectorAll('.seat').forEach(seat => {
    seat.addEventListener('click', () => {
        if (seat.classList.contains('reserved')) {
            return;
        }

        const seatId = seat.getAttribute('data-seat-id');

        if (seat.classList.contains('selected')) {
            seat.classList.remove('selected');
            selectedSeatIds.delete(seatId);
        } else {
            seat.classList.add('selected');
            selectedSeatIds.add(seatId);
        }

        document.getElementById('selectedSeats').value = Array.from(selectedSeatIds).join(',');
    });
});
</script>

</body>
</html>
