package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Component
@Table(name="credit_card_details")
public class CreditCardDetails {

    @Id
    private long card_number;
    private int exp_date;
    private int cvv;
    private String card_owner_name;
}
