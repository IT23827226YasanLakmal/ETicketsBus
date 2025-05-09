<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Raise a Ticket</title>

  <!-- Bootstrap 5 CDN -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="bg-light">

<div class="container mt-5">
  <div class="row justify-content-center">
    <div class="col-12 col-md-10 col-lg-8">
      <div class="card shadow-sm">
        <div class="card-header bg-primary text-white text-center">
          <h4 class="mb-0">Raise a Ticket</h4>
        </div>
        <div class="card-body">
          <form action="TicketInsertServlet5414" method="post" novalidate>
            <div class="row g-3">
              <div class="col-md-6">
                <label for="studentId" class="form-label">Student ID</label>
                <input type="text" class="form-control" id="studentId" name="studentId" placeholder="Enter your student ID" required>
              </div>
              <div class="col-md-6">
                <label for="name" class="form-label">Name</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="Enter your full name" required>
              </div>

              <div class="col-md-6">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email address" required>
              </div>
              <div class="col-md-6">
                <label for="contact" class="form-label">Contact No</label>
                <input type="tel" class="form-control" id="contact" name="contactNo" placeholder="Enter your contact number" required>
              </div>

              <div class="col-md-6">
                <label for="faculty" class="form-label">Faculty</label>
                <select class="form-select" id="faculty" name="faculty" required>
                  <option value="" selected disabled>-- Choose Faculty --</option>
                  <option value="computing">Computing</option>
                  <option value="engineering">Engineering</option>
                  <option value="business">Business</option>
                  <option value="arts">Arts</option>
                  <option value="technology">Technology</option>
                </select>
              </div>
              <div class="col-md-6">
                <label for="inquiryType" class="form-label">Inquiry Type</label>
                <select class="form-select" id="inquiryType" name="inqType" required>
                  <option value="" selected disabled>-- Choose Inquiry Type --</option>
                  <option value="academic">Academic</option>
                  <option value="nonacademic">Non-Academic</option>
                  <option value="technical">Technical</option>
                  <option value="other">Other</option>
                </select>
              </div>

              <div class="col-12">
                <label for="subject" class="form-label">Subject</label>
                <input type="text" class="form-control" id="subject" name="subject" placeholder="Enter the subject" required>
              </div>

              <div class="col-12">
                <label for="message" class="form-label">Message</label>
                <textarea class="form-control" id="message" name="inquiry" rows="5" placeholder="Enter your message here..." required></textarea>
              </div>

              <div class="col-12 d-grid">
                <button type="submit" class="btn btn-primary">Submit Ticket</button>
              </div>
            </div> <!-- end row -->
          </form>
        </div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
