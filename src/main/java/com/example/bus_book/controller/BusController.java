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

import java.util.List;

@Controller
public class BusController {

    @Autowired
    private BusService busService;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/buses")
    public String showBuses(@RequestParam String departure, @RequestParam String destination, Model model) {
        List<Bus> buses = busService.findBuses(departure, destination);//or model attribute
        model.addAttribute("buses", buses);
        return "buses";
    }

    @PostMapping("/book-bus")
    public String bookBus(@RequestParam Long busId, @RequestParam String passengerName, @RequestParam String seatNumber) {
        bookingService.bookBus(busId, passengerName, seatNumber);
        return "redirect:/booking-success";//or booking-success
    }
}