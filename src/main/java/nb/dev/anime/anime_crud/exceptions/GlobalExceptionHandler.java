package nb.dev.anime.anime_crud.exceptions;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorBody> studioNotFoundExceptionHandler(ResourceNotFoundException ex) {
        ErrorBody exBody = new ErrorBody(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage()
        );
        return new ResponseEntity<ErrorBody>(exBody, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorBody> constraintViolationException(ConstraintViolationException ex) {
        String errorMsg = ex.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage).collect(Collectors.joining(" "));

        ErrorBody exBody = new ErrorBody(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                errorMsg
        );
        return new ResponseEntity<ErrorBody>(exBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorBody> httpMessageNotReadableException(HttpMessageNotReadableException ex){
        String errorMsg = "O anime precisa ter um desses status: IN_PRODUCTION, IN_RELEASE, COMPLETE.";
        ErrorBody exBody = new ErrorBody(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                errorMsg
        ); return new ResponseEntity<>(exBody, HttpStatus.BAD_REQUEST);
    }




}
