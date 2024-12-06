package webCalendarSpring;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<String> handleValidationExceptions(Exception e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>("", HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler(value = NoEventFoundException.class)
    public ResponseEntity<ExceptionHandlerResponseDTO> handleNoElementFoundExceptions(Exception e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(new ExceptionHandlerResponseDTO("The event doesn't exist!"), HttpStatusCode.valueOf(404));
    }

    public record ExceptionHandlerResponseDTO(String message) {
    }
}
