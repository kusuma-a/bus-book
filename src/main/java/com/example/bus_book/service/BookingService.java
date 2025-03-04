package com.example.bus_book.service;


import com.example.bus_book.entity.Booking;
import com.example.bus_book.entity.Bus;
import com.example.bus_book.entity.User;
import com.example.bus_book.repository.BookingRepository;
import com.example.bus_book.repository.BusRepository;
import com.example.bus_book.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Booking> getUserBookings() {
        // Fetch bookings for the logged-in user
        return bookingRepository.findByUserEmail(SecurityContextHolder.getContext().getAuthentication().getName());
    }

    public void bookBus(Long busId, String passengerName, String seatNumber) {
        Bus bus = busRepository.findById(busId)
                .orElseThrow(() -> new RuntimeException("Bus not found"));

        // Fetch the logged-in user from the database
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Create a new booking
        Booking booking = new Booking();
        booking.setPassengerName(passengerName);
        booking.setSeatNumber(seatNumber);
        booking.setBookingDate(new Date());
        booking.setBus(bus);
        booking.setUser(user);

        // Save the booking to the database
        bookingRepository.save(booking);
    }




}