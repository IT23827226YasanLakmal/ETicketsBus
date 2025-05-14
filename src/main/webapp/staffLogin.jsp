<%@ page contentType="text/html;charset=UTF-8" %>

<%
    String staffName = (String) session.getAttribute("staffName");
    if (staffName != null) {
        response.sendRedirect("bus_operator_dashboard.jsp"); // Prevent already logged-in users from accessing login page
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Staff Login</title>
    <!-- Bootstrap 5 CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container vh-100 d-flex justify-content-center align-items-center">
    <div class="col-md-5">
        <div class="card w-100 shadow-lg border-0">
            <div class="card-header text-center bg-primary text-white">
                <h4 class="mb-0">Staff Login</h4>
            </div>
            <div class="card-body p-4">
                <form action="staffLoginServlet" method="post">
                    <div class="mb-3">
                        <label for="email" class="form-label">Email address</label>
                        <input type="text" class="form-control" id="email" name="email" required placeholder="Enter your email">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password</label>
                        <input type="password" class="form-control" id="password" name="password" required placeholder="Enter your password">
                    </div>
                    <button type="submit" class="btn btn-primary w-100 fw-bold">Login</button>
                </form>

                <% if (request.getAttribute("error") != null) { %>
                    <div class="alert alert-danger mt-3" role="alert">
                        <%= request.getAttribute("error") %>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
</div>

</body>
</html>
