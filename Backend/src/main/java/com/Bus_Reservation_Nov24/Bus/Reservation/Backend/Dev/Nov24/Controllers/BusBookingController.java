package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.APIResponse.ApiResponse;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
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
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<Optional<BookingDetails>> getBookingDetails(@PathVariable long bookingId) {
       Optional<BookingDetails> reponseDetails =  service.getBookingDetails(bookingId);
       return  new ResponseEntity<>(reponseDetails, HttpStatus.OK);
    }

    // PostMapper for Saving Booking Details
    //@RequestBody helps in getting form data from front-end in JSON format
    @PostMapping("/booking")
    public ResponseEntity<ApiResponse> setBookingDetails(@RequestBody BookingDetails details) {
      ApiResponse savedDetails = service.setBookingDetails(details);
        System.out.println("Saved Booking Details");
      return  new ResponseEntity<>(savedDetails, HttpStatusCode.valueOf(savedDetails.getStatusCode()));
    }
}
