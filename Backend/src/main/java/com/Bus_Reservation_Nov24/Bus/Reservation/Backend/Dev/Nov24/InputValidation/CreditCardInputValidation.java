package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.InputValidation;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import org.springframework.stereotype.Component;

@Component
public class CreditCardInputValidation {
    public String cardInputValidation(CreditCardDetails cardDetails) {
        StringBuilder missingInputCardDetails = new StringBuilder();

        try {
            if (cardDetails.getCard_number() == 0) {
                missingInputCardDetails.append("Missing Card Number");
            }

            if (cardDetails.getCvv() == 0) {
                missingInputCardDetails.append("Missing CVV");
            }
            if (cardDetails.getExp_date().isEmpty()) {
                missingInputCardDetails.append("Missing Card Expiry Date");
            }
            if (cardDetails.getCard_owner_name().isEmpty()) {
                missingInputCardDetails.append("Card Owner Name Missing");
            }
            return "Valid";
        } catch (Exception e) {
            return e.getMessage() + " error in Card Input Validation Class";
        }
    }
}
