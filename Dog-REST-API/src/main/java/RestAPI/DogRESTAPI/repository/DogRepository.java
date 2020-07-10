package RestAPI.DogRESTAPI.repository;

import RestAPI.DogRESTAPI.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogRepository extends CrudRepository<Dog, Long> {
    //creating, reading, updating, and deleting Dog objects

    @Query("SELECT D.id, D.breed FROM Dog D WHERE D.id = :id")
    //use an id as input to findBreedById, add a : into the query line to feed in from my method
    String findBreedByID(Long id);

    @Query("SELECT D.id, D.breed FROM Dog D")
    List<String> findAllBreed();

    @Query("SELECT D.id, D.breed FROM Dog D")
    List<String> findAllName();

    @Query("SELECT D.name, D.owner FROM Dog D WHERE D.name = :name")
    String findOwnerByName(String name);
}
