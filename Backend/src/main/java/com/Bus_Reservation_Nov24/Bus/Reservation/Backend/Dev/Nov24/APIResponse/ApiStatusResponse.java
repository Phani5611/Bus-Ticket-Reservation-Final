package com.Bus_Reservation_Nov24.Bus.Reservation.Backend.Dev.Nov24.APIResponse;


// This class is for returning Api Response Body with Status Code and Message.
// Used Only in Registration API Response since we don't need to get hold of the booking ID in JSON data response.
public class ApiStatusResponse {
    private  int statusCode;
    private  String message;

    public ApiStatusResponse(int statusCode, String message){
        this.statusCode=statusCode;
        this.message=message;
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
