package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface BusBookingRepo extends JpaRepository<BookingDetails,Long> {
}
