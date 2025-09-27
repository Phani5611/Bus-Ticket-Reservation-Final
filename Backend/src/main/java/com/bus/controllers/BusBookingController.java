package com.bus.controllers;

import com.bus.apiresponse.ApiResponse;
import com.bus.exceptions.ResourceNotFoundException;
import com.bus.model.BookingDetails;
import com.bus.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/ap1/v1/booking")
public class BusBookingController {

    @Autowired
    private BookingService service;


    // Fetch All Bookings
    @GetMapping
    public ResponseEntity<List<BookingDetails>>getAllBookings(){
        List<BookingDetails> allDetails = service.getAllBookingDetails();
        return  new ResponseEntity<>(allDetails,HttpStatus.OK);
    }

    // Fetch Mapper for Booking Details
    @GetMapping("/{bookingId}")
    public ResponseEntity<BookingDetails> getBookingDetails(@PathVariable UUID bookingId) throws ResourceNotFoundException {
       BookingDetails reponseDetails =  service.getBookingDetails(bookingId);
       return  new ResponseEntity<>(reponseDetails, HttpStatus.OK);
    }

    // PostMapper for Saving Booking Details
    //@RequestBody helps in getting form data from front-end in JSON format
    @PostMapping
    public ResponseEntity<ApiResponse> setBookingDetails(@RequestBody BookingDetails details) {
      ApiResponse savedDetails = service.setBookingDetails(details);
        System.out.println("Saved Booking Details");
      return  new ResponseEntity<>(savedDetails, HttpStatusCode.valueOf(savedDetails.getStatusCode()));
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<ApiResponse> cancel(@PathVariable UUID bookingId){
        ApiResponse responseCancel = service.cancelTicket(bookingId);
        return new ResponseEntity<>(responseCancel, HttpStatusCode.valueOf(responseCancel.getStatusCode()));
    }
}
