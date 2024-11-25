package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.APIResponse;

import org.springframework.stereotype.Component;


//Responsible for handling the status code's, success / error messages and Booking ID  to get hold of it.
public class ApiResponse {
    private int statusCode;
    private String message;
    private long bookingId;

    public ApiResponse(int statusCode,String message,long bookingId) {
        this.statusCode = statusCode;
        this.message = message;
        this.bookingId = bookingId;
    }

    public long getBookingId() {
        return bookingId;
    }

    public void setBookingId(long bookingId) {
        this.bookingId = bookingId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
