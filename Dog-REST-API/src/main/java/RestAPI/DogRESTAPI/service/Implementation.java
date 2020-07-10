package RestAPI.DogRESTAPI.service;

import RestAPI.DogRESTAPI.entity.Dog;
import RestAPI.DogRESTAPI.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Implementation implements DogService {
    @Autowired
    DogRepository dogRepository;
    public List<Dog> retrieveDogs() {
        return (List<Dog>) dogRepository.findAll();
    }
    public List<String> retrieveDogBreed() {
        return (List<String>) dogRepository.findAllBreed();
    }
    public String retrieveDogBreedByID(Long id) {
        Optional<String> optionalBreed = Optional.ofNullable(dogRepository.findBreedByID(id));
        String breed = optionalBreed.orElseThrow(DogNotFoundException::new);
        return breed;
    }
    public List<String> retrieveDogNames() {
        return (List<String>) dogRepository.findAllName();
    }
    public String retrieveDogOwnerNames(String name) {
        String owner = dogRepository.findOwnerByName(name);
        return owner;
    }
}
