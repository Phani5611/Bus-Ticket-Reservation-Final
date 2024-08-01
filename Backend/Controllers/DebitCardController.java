package com.bus.BusReservation.controllers;

import com.bus.BusReservation.model.BookingDetails;

import com.bus.BusReservation.model.DebitCardDetails;
import com.bus.BusReservation.service.ServiceDebitCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
public class DebitCardController {


        @Autowired
        private ServiceDebitCard service;

        @GetMapping("debitCardPayment")
        public List<DebitCardDetails> getDebitCardDetails(){
            
            return service.getDebitCardDetails();
        }

        @PostMapping("debitCardPayment")
        public String setDebitCardDetails(@RequestBody DebitCardDetails dcdetails){
            //ccdetails.setUsername(details.getName());
            service.setDebitCardDetails(dcdetails);
            return "Debit Card Details Saved Successfully";
        }
}
