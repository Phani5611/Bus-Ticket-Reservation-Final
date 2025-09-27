package com.bus.exceptions;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({ "errorName","status", "message", "endpoint", "timestamp" })
public class ErrorResponse {
    private String ErrorName;
    private Integer status;
    private  String message;
    private String endpoint;
    private LocalDateTime timestamp;
}
