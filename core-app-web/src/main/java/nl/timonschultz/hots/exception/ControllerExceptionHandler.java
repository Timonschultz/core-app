package nl.timonschultz.hots.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String FOUT_OPGETREDEN = "Er is een fout opgetreden: {}";

    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<ExceptionError> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error(FOUT_OPGETREDEN, e.getMessage());
        ExceptionError error = new ExceptionError(400, e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
