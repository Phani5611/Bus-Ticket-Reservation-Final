package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class LoginRequest {

    @Id
    private String username;
    private String password;
}
