package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRegistrationRepo extends JpaRepository<User,String> {

    User findByUsername(String username);
}
