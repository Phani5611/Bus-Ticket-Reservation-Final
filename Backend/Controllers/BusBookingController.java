package com.bus.BusReservation.controllers;

import com.bus.BusReservation.model.BookingDetails;
import com.bus.BusReservation.service.ServiceBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BusBookingController {

    @Autowired
    private BookingDetails details;

    @Autowired
    private ServiceBooking service;

    @GetMapping("booking")
    public List<BookingDetails> getBookingDetails(){
        return service.getBookingDetails();
    }
    @PostMapping("booking")
    public void setBookingDetails( @RequestBody BookingDetails details){
      service.setBookingDetails(details);
      System.out.println("Booking Details Saved Successfully");
    }
}
