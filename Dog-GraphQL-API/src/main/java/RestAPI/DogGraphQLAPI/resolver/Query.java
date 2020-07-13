package RestAPI.DogGraphQLAPI.resolver;

import RestAPI.DogGraphQLAPI.entity.Dog;
import RestAPI.DogGraphQLAPI.repository.DogRepository;
import RestAPI.DogGraphQLAPI.service.DogNotFoundException;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private DogRepository dogRepository;
    public Query(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }
    public Iterable<Dog> findAllDogs() {
        return dogRepository.findAll();
    }
    public Dog findDogById(Long ID) {
        Optional<Dog> optionalDog = dogRepository.findById(ID);
        if (optionalDog.isPresent()) {
            return optionalDog.get();
        }
        else {
            throw new DogNotFoundException("DOG NOT FOUND", ID);
        }
    }
}
