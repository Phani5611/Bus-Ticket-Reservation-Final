package com.bus.validations;

import com.bus.model.BookingDetails;
import org.springframework.stereotype.Component;

@Component
public class InputValidation {
    public String inputValidation(BookingDetails details) {
        StringBuilder validate = new StringBuilder();
        try {
            if (details.getUsername().isEmpty()) {
                validate.append("Missing Passenger Name");
            }
            else if
            (details.getBoarding().isEmpty()) validate.append("Boarding field is empty");

            else if
            (details.getDestination().isEmpty()) validate.append("Destination is empty");

            else if
            (details.getDate()==null) validate.append("Date and time is empty");

            return "Valid";
        }
        catch (Exception e){
           return e.getMessage()+" In Input Validation Class";
        }
    }
}
