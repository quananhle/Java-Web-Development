package RestAPI.DogGraphQLAPI.mutator;

import RestAPI.DogGraphQLAPI.entity.Dog;
import RestAPI.DogGraphQLAPI.repository.DogRepository;
import RestAPI.DogGraphQLAPI.service.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private DogRepository dogRepository;
    public Mutation (DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    public boolean deleteDogBreed(String breed) {
        boolean isDeleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        //Loop through all dogs to check the breeds
        if (Dog dog : allDogs) {
            if (dog.getBreed().equals(breed)) {
                //Delete if breed is found
                dogRepository.delete(d);
                isDeleted = true;
            }
        }
        //Exception if breed not found
        if(!isDeleted) {
            throw new BreedNotFoundException("BREED NOT FOUND", breed);
        }
        return isDeleted;
    }
    public Dog updateDogName(String newName, Long ID) {
        Optional<Dog> optionalDog = dogRepository.findById(ID);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            //Set up the new name
            dog.setName(newName);
            dogRepository.save(dog);
            return dog;
        }
        else {
            throw new DogNotFoundException("DOG NOT FOUND", ID);
        }
    }
}
