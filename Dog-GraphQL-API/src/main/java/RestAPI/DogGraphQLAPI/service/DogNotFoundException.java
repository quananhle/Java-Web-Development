package RestAPI.DogGraphQLAPI.service;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "DOG NOT FOUND")
public class DogNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();
    //default constructor
    public DogNotFoundException() {}
    //non-default constructor
    public DogNotFoundException(String message, Long invalidDogID) {
        super(message);
        extensions.put("INVALID DOG ID", invalidDogID);
    }
    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }
    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }
    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
