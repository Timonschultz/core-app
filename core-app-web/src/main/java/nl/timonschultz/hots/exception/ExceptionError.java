package nl.timonschultz.hots.exception;

import java.time.LocalDateTime;

class ExceptionError {

    private String timestamp;
    private int status;
    private String message;

    ExceptionError(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = LocalDateTime.now().toString();
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }

}