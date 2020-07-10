package RestAPI.DogRESTAPI.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "DOG NOT FOUND")
public class DogNotFoundException extends RuntimeException {
    //default constructor
    public DogNotFoundException() {}
    //non-default constructor
    public DogNotFoundException(String message) {
        super(message);
    }
}
