<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Payment Page</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #e0f7fa, #ffffff);
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 40px auto;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 16px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            color: #1d3557;
        }

        .summary {
            background-color: #f1f5f9;
            padding: 15px;
            border-radius: 10px;
            margin-bottom: 25px;
        }

        .summary h3 {
            margin-top: 0;
            color: #333;
            border-bottom: 1px solid #ccc;
            padding-bottom: 8px;
        }

        .summary-item {
            display: flex;
            justify-content: space-between;
            padding: 8px 0;
        }

        .summary-item span {
            color: #555;
        }

        form input, form select {
            width: 100%;
            padding: 12px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 15px;
        }

        form label {
            font-weight: bold;
            color: #333;
            margin-bottom: 6px;
            display: block;
        }

        .pay-btn {
            width: 100%;
            background-color: #457b9d;
            color: white;
            padding: 14px;
            border: none;
            border-radius: 10px;
            font-size: 18px;
            cursor: pointer;
            transition: background 0.3s ease;
        }

        .pay-btn:hover {
            background-color: #1d3557;
        }

        .note {
            text-align: center;
            font-size: 13px;
            color: #666;
            margin-top: 15px;
        }

        .badge {
            display: inline-block;
            background-color: #2a9d8f;
            color: white;
            padding: 4px 10px;
            border-radius: 12px;
            font-size: 12px;
        }

    </style>
</head>
<body>

<div class="container">
    <h2>Confirm Your Payment</h2>

    <!-- ==== Payment Summary ===== -->
    <div class="summary">
        <h3>Booking Summary</h3>
        <div class="summary-item">
            <span>Selected Seats:</span>
            <span><c:forEach var="seat" items="${selectedSeats}">${seat} </c:forEach></span>
        </div>
        <div class="summary-item">
            <span>Bus Number:</span>
            <span>${busNumber}</span>
        </div>
        <div class="summary-item">
            <span>Travel Date:</span>
            <span>${travelDate}</span>
        </div>
        <div class="summary-item">
            <span>Total Price:</span>
            <span><strong>Rs. ${totalPrice}</strong></span>
        </div>
    </div>

    <!-- ==== Payment Form ===== -->
    <form action="processPayment" method="post">
        <label for="cardName">Cardholder Name</label>
        <input type="text" id="cardName" name="cardName" required placeholder="John Doe">

        <label for="cardNumber">Card Number</label>
        <input type="text" id="cardNumber" name="cardNumber" required placeholder="1234 5678 9012 3456">

        <label for="expiryDate">Expiry Date</label>
        <input type="month" id="expiryDate" name="expiryDate" required>

        <label for="cvv">CVV</label>
        <input type="password" id="cvv" name="cvv" required placeholder="123">

        <button type="submit" class="pay-btn">Pay Now</button>
    </form>

    <div class="note">
        <span class="badge">Secure Payment</span><br>
        Your payment details are encrypted and secure.
    </div>
</div>

</body>
</html>
