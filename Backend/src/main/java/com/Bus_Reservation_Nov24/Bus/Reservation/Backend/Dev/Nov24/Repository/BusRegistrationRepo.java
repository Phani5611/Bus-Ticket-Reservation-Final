package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRegistrationRepo extends JpaRepository<Passenger,String> {

}
