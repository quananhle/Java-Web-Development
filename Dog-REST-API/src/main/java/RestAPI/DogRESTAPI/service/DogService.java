package RestAPI.DogRESTAPI.service;

import RestAPI.DogRESTAPI.entity.Dog;

import java.util.List;

public interface DogService {
    /**
     * The service should perform the operations:
     *     retrieveDogBreed
     *     retrieveDogBreedById
     *     retrieveDogNames
     *     retrieveDogOwnerNames
     **/
    List<Dog> retrieveDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedByID(Long id);
    List<String> retrieveDogNames();
    String retrieveDogOwnerNames(String name);
}
