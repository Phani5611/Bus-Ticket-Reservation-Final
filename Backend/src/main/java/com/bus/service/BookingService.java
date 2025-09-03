package com.bus.service;


import com.bus.exceptions.BookingNotFoundException;
import com.bus.exceptions.InvalidInputException;
import com.bus.validations.InputValidation;
import com.bus.apiresponse.ApiResponse;
import com.bus.model.BookingDetails;
import com.bus.model.Users;
import com.bus.repository.BusBookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookingService {

    @Autowired
    private Users user;


    @Autowired
    private BusBookingRepo BookingDetailsRepo;

    @Autowired
    private InputValidation validation;


    // Fetch All Bookings Service
    public List<BookingDetails> getAllBookingDetails() {
        return  BookingDetailsRepo.findAll();
    }

    //Fetching Details by ID from DB
    public Optional<BookingDetails> getBookingDetails(UUID bookingId) {
        Optional<BookingDetails> savedBookingDetails = BookingDetailsRepo.findById(bookingId);
        if (savedBookingDetails.isPresent()) {
            return savedBookingDetails;
        }
        return savedBookingDetails;
    }


    // Post Mapping Booking Service - Saving Booking Details
    // 201 - Booking Created, 400 - Bad Request for Input Fields, 500 - Internal Server Error
    public ApiResponse setBookingDetails(BookingDetails details) {
       String validInput = validation.inputValidation(details);
       try{
           //Check for valid inputs
           if (!"Valid".equals(validInput)){
               throw new InvalidInputException(validInput);
           }
           // Fare calculation based on station codes
           details.setAmount(Math.abs(details.getBoarding_code()-details.getDestination_code()) * 10);
           // Success in saving booking details
           BookingDetailsRepo.save(details);
           return  new ApiResponse(201,"Booking Successful",details.getBookingId());
       }
       catch (InvalidInputException invalidInputException){
           return new ApiResponse(400,invalidInputException.getMessage(),details.getBookingId());
       }

       catch (Exception e){
           return  new ApiResponse(500,"Unexpected error in booking block of service",details.getBookingId()); // Internal Server Error
       }
    }



    // Cancel Booking Service
    // 200 - Booking found and deleted, 404 - Booking not found to delete, 500-Internal server error
    public ApiResponse cancelTicket(UUID bookingId) {
        try{
            // Check for booking present or not.
            if(BookingDetailsRepo.findById(bookingId).isPresent()){
                BookingDetailsRepo.deleteById(bookingId);
                return  new ApiResponse(200,"Booking is deleted",bookingId);
            }
            else{
                throw new BookingNotFoundException("Booking - "+bookingId + " is not found to delete");
            }
        }
        catch (BookingNotFoundException bookingNotFoundException){
            return new ApiResponse(404,bookingNotFoundException.getMessage(),bookingId);
        }
        catch (Exception e){
           return new ApiResponse(500,"Unexpected error in delete block of service",bookingId);
        }
    }

}
