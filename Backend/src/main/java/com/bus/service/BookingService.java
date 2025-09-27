package com.bus.service;


import com.bus.exceptions.BadRequestException;
import com.bus.exceptions.ResourceNotFoundException;
import com.bus.validations.InputValidation;
import com.bus.apiresponse.ApiResponse;
import com.bus.model.BookingDetails;
import com.bus.model.Users;
import com.bus.repository.TicketBookingRepository;
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
    private TicketBookingRepository ticketBookingRepository;

    @Autowired
    private InputValidation validation;


    // Fetch All Bookings Service
    public List<BookingDetails> getAllBookingDetails() {
        return  ticketBookingRepository.findAll();
    }

    //Fetching Details by ID from DB
    public BookingDetails getBookingDetails(UUID bookingId){
        return ticketBookingRepository.findById(bookingId)
                .orElseThrow(()->new ResourceNotFoundException("Booking Details Not Found with this BookingId : "+bookingId));
    }


    // Post Mapping Booking Service - Saving Booking Details
    // 201 - Booking Created, 400 - Bad Request for Input Fields, 500 - Internal Server Error
    public ApiResponse setBookingDetails(BookingDetails details) {
       String validInput = validation.inputValidation(details);
       try{
           //Check for valid inputs
           if (!"Valid".equals(validInput)){
               throw new BadRequestException(validInput);
           }
           // Fare calculation based on station codes
           details.setAmount(Math.abs(details.getBoarding_code()-details.getDestination_code()) * 10);
           // Success in saving booking details
           ticketBookingRepository.save(details);
           return  new ApiResponse(201,"Booking Successful",details.getBookingId());
       }
       catch (BadRequestException invalidInputException){
           return new ApiResponse(400,invalidInputException.getMessage(),details.getBookingId());
       }

       catch (Exception e){
           return  new ApiResponse(500,"Unexpected error in booking block of service",details.getBookingId()); // Internal Server Error
       }
    }



    public ApiResponse cancelTicket(UUID bookingId) {
        try{
            // Check for booking present or not.
            if(ticketBookingRepository.findById(bookingId).isPresent()){
                ticketBookingRepository.deleteById(bookingId);
                return  new ApiResponse(200,"Booking is deleted",bookingId);
            }
            else{
                throw new ResourceNotFoundException("Booking - "+bookingId + " is not found to delete");
            }
        }
        catch (ResourceNotFoundException exception){
            return new ApiResponse(404,exception.getMessage(),bookingId);
        }
        catch (Exception e){
           return new ApiResponse(500,"Unexpected error in delete block of service",bookingId);
        }
    }

}
