package com.example.bus_book.controller;


//import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {

    @GetMapping("/payment")
    public String showPaymentPage(@RequestParam Double amount, Model model) {
        model.addAttribute("amount", amount);
        return "payment";
    }

    @PostMapping("/process-payment")
    public String processPayment(@RequestParam String cardNumber, @RequestParam Double amount) {
        // Mock payment processing logic
        if (cardNumber.length() == 16) {
            return "redirect:/booking-success";
        } else {
            return "redirect:/payment-failed";
        }
    }

    @GetMapping("/booking-success")
    public String showBookingSuccessPage() {
        return "booking-success";
    }

    @GetMapping("/payment-failed")
    public String showPaymentFailedPage() {
        return "payment-failed";
    }
}