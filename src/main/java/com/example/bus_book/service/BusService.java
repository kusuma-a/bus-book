package com.example.bus_book.service;


import com.example.bus_book.entity.Bus;
import com.example.bus_book.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;

    public List<Bus> findBuses(String departure, String destination) {
        return busRepository.findByDepartureAndDestination(departure, destination);
    }
    public Bus findBusById(Long busId){
        return busRepository.findById(busId).orElseThrow(()-> new RuntimeException("Bus not found"));
    }

    //public void bookBus(Long busId, String passengerName, String seatNumber) {

    //}
}