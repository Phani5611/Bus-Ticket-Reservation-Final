package com.bus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name ="booking_details")
public class BookingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID bookingId;

    @Column(name="username")
    private String username;

    @Column(name = "boarding_code")
    private Integer boarding_code;

    @Column(name="boarding_point")
    private String boarding;


    @Column(name = "destination_code")
    private int destination_code;

    @Column(name="destination_point")
    private String destination;

    @Column(name = "booking_date")
    private LocalDateTime date;

    @Column(name = "amount")
    private Integer amount;
}
