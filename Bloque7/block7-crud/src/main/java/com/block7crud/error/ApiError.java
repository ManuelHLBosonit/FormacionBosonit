package com.block7crud.error;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;


@Data
public class ApiError {
    private HttpStatus status;
    private String message;
    private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    public ApiError(HttpStatus httpStatus, String message) {
        this.status = httpStatus;
        this.message = message;
    }
}
