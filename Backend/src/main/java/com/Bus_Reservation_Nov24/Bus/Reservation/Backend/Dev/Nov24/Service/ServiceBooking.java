package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.User;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.BusBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceBooking {
    @Autowired
    private User user;
    @Autowired
    private BusBookingRepo BookingDetailsRepo;

    public BookingDetails setBookingDetails(BookingDetails details) {
        BookingDetailsRepo.save(details);
        return details;
    }


    //Getting Details by Id from DB
    public ResponseEntity<BookingDetails> getBookingDetails(long bookingId) {

        Optional<BookingDetails> savedBookingDetails =  BookingDetailsRepo.findById(bookingId);
        if(savedBookingDetails.isPresent()){
            return ResponseEntity.ok(savedBookingDetails.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}