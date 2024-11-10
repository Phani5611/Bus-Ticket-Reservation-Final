package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


//Class contains Users -> Username and Password which refers to DB
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name="passenger_details")
public class Users {
    @Id
    private String username;
    private String name;
    private String email;
    private String password;
    private String cpassword;

}
