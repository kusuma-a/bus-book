package com.example.bus_book.repository;

import com.example.bus_book.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface BusRepository extends JpaRepository<Bus, Long> {
    List<Bus> findByDepartureAndDestination(String departure, String destination);
    Optional<Bus> findById(Long busId);
}