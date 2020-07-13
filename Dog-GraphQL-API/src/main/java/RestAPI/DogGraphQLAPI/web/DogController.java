package RestAPI.DogGraphQLAPI.web;

import RestAPI.DogGraphQLAPI.entity.Dog;
import RestAPI.DogGraphQLAPI.repository.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DogController {
    /**
     * The controller should handle requests for retrieving:
     *     a list of Dog breeds
     *     a list of Dog breeds by Id
     *     a list of Dog names
     **/
    private DogService dogService;

    @Autowired
    public void setDogService(DogService dogService) {
        this.dogService = dogService;
    }
    public DogService getDogService() {
        return dogService;
    }

    @GetMapping("/dogs")
    public ResponseEntity<List<Dog>> getAllDogs() {
        List<Dog> list = dogService.retrieveDogs();
        return new ResponseEntity<List<Dog>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/breed")
    public ResponseEntity<List<String>> getDogBreeds() {
        List<String> list = dogService.retrieveDogBreed();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}/breed")
    public ResponseEntity<String> getBreedByID(@PathVariable Long ID) {
        String breed = dogService.retrieveDogBreedByID(ID);
        return new ResponseEntity<String>(breed, HttpStatus.OK);
    }

    @GetMapping("/dogs/name")
    public ResponseEntity<List<String>> getDogNames() {
        List<String> list = dogService.retrieveDogNames();
        return new ResponseEntity<List<String>>(list, HttpStatus.OK);
    }

    @GetMapping("/dogs/owner")
    public ResponseEntity<String> getDogOwnerName(@PathVariable String NAME) {
        String owner = dogService.retrieveDogOwnerNames(NAME);
        return new ResponseEntity<String>(owner, HttpStatus.OK);
    }
}
