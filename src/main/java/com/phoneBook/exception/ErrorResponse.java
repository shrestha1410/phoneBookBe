package com.phoneBook.exception;

import lombok.*;
import org.springframework.http.HttpStatusCode;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
        private final int errorCode;
        private final String message;
        private Date timestamp;
    }
