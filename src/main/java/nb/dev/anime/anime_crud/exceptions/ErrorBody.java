package nb.dev.anime.anime_crud.exceptions;

import jakarta.persistence.Id;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorBody {
    private LocalDateTime timesTemp;
    private Integer status;
    private String error;
    private String message;

    public ErrorBody(LocalDateTime timesTemp, Integer status, String error, String message) {
        this.timesTemp = timesTemp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public LocalDateTime getTimesTemp() {
        return timesTemp;
    }

    public void setTimesTemp(LocalDateTime timesTemp) {
        this.timesTemp = timesTemp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
