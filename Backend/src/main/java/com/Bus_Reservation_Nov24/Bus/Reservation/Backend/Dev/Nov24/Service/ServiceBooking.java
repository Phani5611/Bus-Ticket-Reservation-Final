package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Passenger;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.BusBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceBooking {
    @Autowired
    private Passenger passenger;
    @Autowired
    private BusBookingRepo BookingDetailsRepo;

    public BookingDetails setBookingDetails(BookingDetails details) {
        BookingDetailsRepo.save(details);
        return details;
    }

    public List<BookingDetails> getBookingDetails() {
        return BookingDetailsRepo.findAll();
    }
}
