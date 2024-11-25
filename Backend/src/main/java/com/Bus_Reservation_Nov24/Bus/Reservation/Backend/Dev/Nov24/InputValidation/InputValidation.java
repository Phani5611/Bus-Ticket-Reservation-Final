package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.InputValidation;

import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.BookingDetails;
import org.springframework.stereotype.Component;

@Component
public class InputValidation {
    public String inputValidation(BookingDetails details) {
        StringBuilder validate = new StringBuilder();
        try {
            if (details.getName().isEmpty()) {
                validate.append("Missing Passenger Name");
            }
            else if (details.getPhone() == 0) {
                validate.append("Phone number is empty ");
            }
            else if
            (details.getBoarding().isEmpty()) validate.append("Boarding field is empty");

            else if
            (details.getDestination().isEmpty()) validate.append("Destination is empty");

            else if
            (details.getDateAndTime()==null) validate.append("Date and time is empty");

            return "Valid";
        }
        catch (Exception e){
           return e.getMessage()+" In Input Validation Class";
        }
    }
}
