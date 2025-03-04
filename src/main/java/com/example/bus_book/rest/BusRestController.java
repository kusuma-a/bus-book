package com.example.bus_book.rest;


import com.example.bus_book.entity.Bus;
import com.example.bus_book.service.BookingService;
import com.example.bus_book.service.BusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buses")
@Tag(name = "Bus API", description = "APIs for managing bus routes and bookings")
public class BusRestController {

    @Autowired
    private BusService busService;

    @Autowired
    private BookingService bookingService;

    @Operation(summary = "Get available buses", description = "Returns a list of buses based on departure and destination")
    @GetMapping("/search")
    public List<Bus> searchBuses(@RequestParam String departure, @RequestParam String destination) {
        return busService.findBuses(departure, destination);
    }

    @Operation(summary = "Book a bus", description = "Books a bus ticket for a user")
    @PostMapping("/book")
    public String bookBus(@RequestParam Long busId, @RequestParam String passengerName, @RequestParam String seatNumber) {
        bookingService.bookBus(busId, passengerName, seatNumber);
        return "Booking successful!";
    }
}