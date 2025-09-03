package com.bus.service;

import com.bus.apiresponse.ApiResponse;
import com.bus.exceptions.BookingNotFoundException;
import com.bus.model.DebitCardDetails;
import com.bus.repository.DebitCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DebitCardService {

    @Autowired
    private DebitCardRepo repo;

    @Autowired
    private DebitCardDetails dcdetails;

    // Fetch Service Debit Card Details
    public Optional<DebitCardDetails> getDebitCardDetails(long bookingId) {
       return repo.findById(bookingId);
    }

    // Post Service Debit Card Details
    public ApiResponse setDebitCardDetails(DebitCardDetails dcdetails) {
        try {
            if (dcdetails.getCard_number() != 0) {
                repo.save(dcdetails);
                return new ApiResponse(200, " Success - Debit Card Details Saved",dcdetails.getBookingId());
            }
            throw new BookingNotFoundException("Booking ID Not Found to Save Debit Card Details");
        }
        catch (BookingNotFoundException bookingNotFoundException){
            return new ApiResponse(404,bookingNotFoundException.getMessage(),dcdetails.getBookingId());
        }
        catch (Exception e){
            return new ApiResponse(500,"Unexpected error in post service saving debit card details bloclk.",dcdetails.getBookingId());
        }
    }
}
