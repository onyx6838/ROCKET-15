package com.vti.config.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private HttpStatus status;
    private String message;
    private String detailMessage;
}
