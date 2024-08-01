package com.bus.BusReservation.service;

import com.bus.BusReservation.model.BookingDetails;
import com.bus.BusReservation.model.Passenger;
import com.bus.BusReservation.repository.BusBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBooking {
    @Autowired
    private Passenger passenger;
    @Autowired
    private BusBookingRepo repo;

    public void setBookingDetails( BookingDetails details) {
        repo.save(details);
    }

    public List<BookingDetails> getBookingDetails() {
       return repo.findAll();
    }
}
