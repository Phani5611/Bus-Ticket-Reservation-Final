package com.bus.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="debit_card_details")
public class DebitCardDetails {


    @Id
    private UUID bookingId;
    private long card_number;
    private int exp_date;
    private int cvv;
    private String card_owner_name;
    private LocalDateTime dateAndTime;
}

