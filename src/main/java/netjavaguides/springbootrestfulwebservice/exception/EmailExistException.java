package netjavaguides.springbootrestfulwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailExistException extends  RuntimeException{
    private String message;


    public EmailExistException(String message) {
        super(message);
    }
}
