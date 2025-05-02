<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" isErrorPage="true"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Error - Application</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="d-flex align-items-center justify-content-center vh-100 bg-light">

<div class="text-center p-5 bg-white shadow rounded">
    <h1 class="display-4 text-danger">Oops!</h1>
    <p class="lead mb-3">An unexpected error has occurred.</p>

    <% if (exception != null) { %>
        <div class="alert alert-danger" role="alert">
            <%= exception.getMessage() %>
        </div>
    <% } %>

    <a href="<%= request.getContextPath() %>/" class="btn btn-primary mt-3">Back to Home</a>
</div>

</body>
</html>
