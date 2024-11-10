package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Controllers;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service.ServiceBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class BusBookingController {

    @Autowired
    private ServiceBooking service;

    @GetMapping("/greet")
    public String greet(){
        return "Hi!";
    }
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<BookingDetails> getBookingDetails(@PathVariable long bookingId) {
       return service.getBookingDetails(bookingId);
    }

    //@RequestBody helps in getting form data from front-end in JSON format
    @PostMapping("/booking")
    public BookingDetails setBookingDetails(@RequestBody BookingDetails details) {
      BookingDetails savedDetails = service.setBookingDetails(details);
       System.out.println("Booking Details Saved Successfully");
       //Returning Booking details to front-end to redirect to next page
       return savedDetails;
    }
}
