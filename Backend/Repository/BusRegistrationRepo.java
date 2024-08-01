package com.bus.BusReservation.repository;

import com.bus.BusReservation.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRegistrationRepo extends JpaRepository<Passenger,String> {
    boolean existsByEmail(String email);
}
