<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FAQ | E-Bus Tickets</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #007ea7, #003249);
            min-height: 100vh;
        }
        .nav-pills .nav-link.active {
            background-color: #007ea7;
        }
        .bg-custom {
            background-color: #ccdbdc;
        }
        .text-custom {
            color: #003249;
        }
        .accordion-button:not(.collapsed) {
            background-color: #e8f1f2;
            color: #007ea7;
        }
        .accordion-button:focus {
            box-shadow: 0 0 0 0.25rem rgba(0, 126, 167, 0.25);
        }
    </style>
</head>
<body>
<div class="container py-4">
    <!-- Header -->
    <div class="d-flex justify-content-between align-items-center bg-custom p-3 rounded mb-4">
        <h1 class="h4 mb-0 text-custom">E-Bus Tickets</h1>
        <div class="d-flex align-items-center">
            <span class="me-2"><i class="bi bi-person-circle"></i></span>
            <span class="text-custom">Admin</span>
        </div>
    </div>

    <!-- Navigation -->
    <ul class="nav nav-pills bg-custom p-2 rounded mb-4">
        <li class="nav-item">
            <a class="nav-link text-custom" href="admin-dashboard.jsp">
                <i class="bi bi-house-door me-1"></i> Home
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-custom" href="about-us.jsp">
                <i class="bi bi-info-circle me-1"></i> About Us
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link active" href="#">
                <i class="bi bi-question-circle me-1"></i> FAQ
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link text-custom" href="#">
                <i class="bi bi-telephone me-1"></i> Contact
            </a>
        </li>
    </ul>

    <!-- FAQ Content -->
    <div class="bg-custom p-4 rounded mb-4">
        <h2 class="text-custom mb-4">
            <i class="bi bi-question-octagon me-2"></i>Frequently Asked Questions
        </h2>
        
        <div class="accordion" id="faqAccordion">
            <!-- Question 1 -->
            <div class="accordion-item mb-3 border-0">
                <h3 class="accordion-header">
                    <button class="accordion-button collapsed rounded" type="button" 
                            data-bs-toggle="collapse" data-bs-target="#faq1">
                        <i class="bi bi-ticket-detailed me-2"></i> How do I book a bus ticket?
                    </button>
                </h3>
                <div id="faq1" class="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                    <div class="accordion-body">
                        Booking is simple! Just select your route, choose your travel date, pick a bus, select seats, 
                        and make payment. You'll receive an e-ticket via email.
                    </div>
                </div>
            </div>
            
            <!-- Question 2 -->
            <div class="accordion-item mb-3 border-0">
                <h3 class="accordion-header">
                    <button class="accordion-button collapsed rounded" type="button" 
                            data-bs-toggle="collapse" data-bs-target="#faq2">
                        <i class="bi bi-credit-card me-2"></i> What payment methods do you accept?
                    </button>
                </h3>
                <div id="faq2" class="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                    <div class="accordion-body">
                        We accept all major credit/debit cards, net banking, and popular mobile payment options. 
                        All transactions are securely processed.
                    </div>
                </div>
            </div>
            
            <!-- Question 3 -->
            <div class="accordion-item mb-3 border-0">
                <h3 class="accordion-header">
                    <button class="accordion-button collapsed rounded" type="button" 
                            data-bs-toggle="collapse" data-bs-target="#faq3">
                        <i class="bi bi-clock me-2"></i> Can I cancel my ticket?
                    </button>
                </h3>
                <div id="faq3" class="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                    <div class="accordion-body">
                        Yes, tickets can be cancelled up to 4 hours before departure. Cancellation charges may apply 
                        depending on when you cancel. Check our cancellation policy for details.
                    </div>
                </div>
            </div>
            
            <!-- Question 4 -->
            <div class="accordion-item mb-3 border-0">
                <h3 class="accordion-header">
                    <button class="accordion-button collapsed rounded" type="button" 
                            data-bs-toggle="collapse" data-bs-target="#faq4">
                        <i class="bi bi-geo-alt me-2"></i> How do I track my bus?
                    </button>
                </h3>
                <div id="faq4" class="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                    <div class="accordion-body">
                        After booking, you'll receive a tracking link in your confirmation email. You can also track 
                        your bus in real-time through our mobile app or website.
                    </div>
                </div>
            </div>
            
            <!-- Question 5 -->
            <div class="accordion-item mb-3 border-0">
                <h3 class="accordion-header">
                    <button class="accordion-button collapsed rounded" type="button" 
                            data-bs-toggle="collapse" data-bs-target="#faq5">
                        <i class="bi bi-headset me-2"></i> How can I contact customer support?
                    </button>
                </h3>
                <div id="faq5" class="accordion-collapse collapse" data-bs-parent="#faqAccordion">
                    <div class="accordion-body">
                        Our 24/7 customer support is available via phone at 1800-123-4567, through live chat on our 
                        website/app, or by email at support@ebustickets.com.
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Footer -->
    <div class="bg-custom p-3 rounded text-center">
        <p class="mb-0 text-custom">
            <i class="bi bi-c-circle me-1"></i>2023 E-Bus Tickets. All rights reserved.
        </p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>>