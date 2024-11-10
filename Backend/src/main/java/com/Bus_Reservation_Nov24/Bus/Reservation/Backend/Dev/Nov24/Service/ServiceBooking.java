package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Users;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.BusBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceBooking {
    @Autowired
    private Users user;
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


    public ResponseEntity<Void> cancelTicket(long bookingId) {
        try{
            if(BookingDetailsRepo.findById(bookingId).isPresent()){
                BookingDetailsRepo.deleteById(bookingId);
                System.out.println("Booking Deleted");
            }
        }
        catch (Exception e){
            System.out.println("Exception in deleteing the booking details in service layer"+e);
        }
        return  ResponseEntity.status(HttpStatus.OK).build();

    }
}
