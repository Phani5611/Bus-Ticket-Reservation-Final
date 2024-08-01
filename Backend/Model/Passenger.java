package com.bus.BusReservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Passenger {
    @Id
    private String username;

    private String name;


    private String email;
    private String password;
    private String cpassword;

}
