package edu.icet.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "IndexOutOfBounds")
public class OutOfRangeException extends IndexOutOfBoundsException{
    public OutOfRangeException(String message) {
        super(message);
    }
}
