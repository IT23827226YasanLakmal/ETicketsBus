<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Profile</title>

<!-- Bootstrap 5 CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
    body {
        background-color: #f8f9fa;
    }
    .profile-card {
        max-width: 600px;
        margin: 40px auto;
    }
    .btn-space {
        margin-right: 10px;
    }
</style>
</head>
<body>

<div class="container profile-card">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white text-center">
            <h3 class="mb-0">Student Profile</h3>
        </div>
        <div class="card-body">
            <p><strong>User ID:</strong> ${sessionScope.user.userID}</p>
            <p><strong>Name:</strong> ${sessionScope.user.name}</p>
            <p><strong>Username:</strong> ${sessionScope.user.username}</p>
            <p><strong>Password:</strong> ${sessionScope.user.password}</p>
            <p><strong>Email:</strong> ${sessionScope.user.gmail}</p>
            <p><strong>Contact No:</strong> ${sessionScope.user.phone}</p>

            <div class="d-flex flex-wrap mt-4">
                <!-- Update Button -->
                <a href="UpdateProfile5414.jsp?userID=${user.userID}&name=${user.name}&username=${user.username}&password=${user.password}&gmail=${user.gmail}&phone=${user.phone}" 
                   class="btn btn-warning btn-space mb-2">Update</a>

                <!-- Delete Form -->
                <form action="DeleteProfile5414" method="post" class="mb-2">
                    <input type="hidden" name="userID" value="${user.userID}">
                    <button type="submit" class="btn btn-danger btn-space">Delete</button>
                </form>

                <!-- Make Appointment Button -->
                <a href="#" class="btn btn-secondary btn-space mb-2">Make an Appointment</a>

                <!-- My Tickets Form -->
                <form action="GetAllTicketServlet5414" method="post" class="mb-2">
                    <input type="submit" class="btn btn-info text-white btn-space" value="My Tickets">
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
