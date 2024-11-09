package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name ="booking_details")
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    private String name;
    private long phone;
    private String boarding;
    private String destination;
    private String dateandtime;
}