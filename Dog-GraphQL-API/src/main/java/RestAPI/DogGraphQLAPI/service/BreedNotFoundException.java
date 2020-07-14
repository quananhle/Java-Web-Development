package RestAPI.DogGraphQLAPI.service;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BreedNotFoundException extends RuntimeException implements GraphQLError {
    private Map<String, Object> extensions = new HashMap<>();
    //default constructor
    public BreedNotFoundException() {}
    //non-default constructor
    public BreedNotFoundException(String message, String dogBreed) {
        super(message);
        extensions.put("INVALID BREED ID", dogBreed);
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
