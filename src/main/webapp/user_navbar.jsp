<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Bootstrap 5 Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="dashboard?action=home">eBusTickets</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarContent" aria-controls="navbarContent"
            aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link" href="dashboard?action=home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="dashboard?action=history">Booking History</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="dashboard?action=profile">Profile</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="dashboard?action=support">Support</a>
        </li>
      </ul>
      <span class="navbar-text">
        <a class="btn btn-outline-light" href="logout.jsp">Logout</a>
      </span>
    </div>
  </div>
</nav>
