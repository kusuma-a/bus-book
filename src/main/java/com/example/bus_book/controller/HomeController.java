package com.example.bus_book.controller;


import com.example.bus_book.entity.Bus;
import com.example.bus_book.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private BusService busService;

    @GetMapping("/home")
    public String showHomePage(
            @RequestParam(required = false) String departure,
            @RequestParam(required = false) String destination,
            Model model) {

        // If search parameters are provided, fetch matching buses
        if (departure != null && destination != null) {
            List<Bus> buses = busService.findBuses(departure, destination);
            model.addAttribute("buses", buses);
        }

        return "home";
    }
}