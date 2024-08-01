package com.bus.BusReservation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String name;
    //private int bookingId;
    private String phone;
    private String boarding;
    private String destination;
    private String dateandtime;
}
