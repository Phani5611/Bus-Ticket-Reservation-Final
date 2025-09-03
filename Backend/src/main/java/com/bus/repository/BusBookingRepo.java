package com.bus.repository;


import com.bus.model.BookingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface BusBookingRepo extends JpaRepository<BookingDetails, UUID> {

}
