package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Service;


import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Exceptions.InvalidInputException;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.InputValidation.CreditCardInputValidation;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.APIResponse.ApiResponse;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Model.CreditCardDetails;
import com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.Repository.CreditCardRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceCreditCard {

    @Autowired
    private CreditCardRepo repo;


    @Autowired
    private CreditCardInputValidation cardInputValidation;


    // Fetch Card Details Service Using Booking ID
    public Optional<CreditCardDetails> getCreditCardDetails(long bookingId) {
        return repo.findById(bookingId);
    }

    // Post Mapping Service Credit Card Details
    // 200 - Credit Card Details Saved, 400 - Missing Input Field, 500 - Unexpected Error
    public ApiResponse setCreditCardDetails(CreditCardDetails ccdetails) {
        String inputValidCardDetails = cardInputValidation.cardInputValidation(ccdetails);
        try{
            // Check for input fields empty or not.
            if(!"Valid".equals(inputValidCardDetails)){
                throw  new InvalidInputException(inputValidCardDetails);
            }
            else{
                repo.save(ccdetails);
                return new ApiResponse(200,"Credit Card Details Saved Successfully",ccdetails.getBookingId());
            }
        }
        catch (InvalidInputException invalidInputException){
            return  new ApiResponse(400,invalidInputException.getMessage(),ccdetails.getBookingId());
        }
        catch (Exception e){
            return  new ApiResponse(500,"Unexpected Error in Service Credit Card Details Block",ccdetails.getBookingId());
        }
    }
}
