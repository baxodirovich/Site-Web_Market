package uz.isystem.siteweb_market.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.ResponseEntity.badRequest;

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler({ServerBadRequestException.class})
    public ResponseEntity<?> handlerException(RuntimeException e) {
        return badRequest().body(e.getMessage());
    }

    @ExceptionHandler({ProfileNotFoundException.class})
    public ResponseEntity<?> handlerException(ProfileNotFoundException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
