package com.example.bus_book.repository;

import com.example.bus_book.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long > {
    List<Booking> findByUserEmail(String name);
}
