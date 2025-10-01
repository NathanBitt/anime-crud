package nb.dev.anime.anime_crud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorBody> studioNotFoundExceptionHandler(ResourceNotFoundException ex) {
        ErrorBody exBody = new ErrorBody(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Recurso não encontrado",
                ex.getMessage()
        ); return new ResponseEntity<ErrorBody>(exBody, HttpStatus.NOT_FOUND);

    }







}
