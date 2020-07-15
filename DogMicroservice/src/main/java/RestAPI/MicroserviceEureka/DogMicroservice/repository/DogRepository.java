package RestAPI.MicroserviceEureka.DogMicroservice.repository;

import RestAPI.MicroserviceEureka.DogMicroservice.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {}
