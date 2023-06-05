package fr.aelion.streamer.exceptions;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorModel {

    private HttpStatus status;
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorModel(HttpStatus status, String message, String details) {
        this.status = status;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }
}