package com.example.bus_book.controller;


import com.example.bus_book.entity.Bus;
import com.example.bus_book.service.BookingService;
import com.example.bus_book.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private BusService busService;

    @GetMapping("/book")
    public String showBookingForm(@RequestParam Long busId, Model model) {
        Bus bus = busService.findBusById(busId);
        model.addAttribute("busId", busId);
        model.addAttribute("price",bus.getPrice());
        return "booking-form";
    }

    @PostMapping("/confirm-book")
    public String bookBus(@RequestParam Long busId, @RequestParam String passengerName, @RequestParam String seatNumber,@RequestParam Double price) {
        bookingService.bookBus(busId, passengerName, seatNumber);
        return "redirect:/payment?amount="+price;
    }
}