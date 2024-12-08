package org.edem.productmanagement.exception;

import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Builder
public class ErrorResponse {
    private String message;
    private LocalDateTime timestamp;
    private String detail;

    public ErrorResponse(String message, LocalDateTime timestamp, String detail) {
        this.message = message;
        this.timestamp = timestamp;
        this.detail = detail;
    }
}
