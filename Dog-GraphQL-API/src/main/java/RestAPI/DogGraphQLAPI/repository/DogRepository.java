package RestAPI.DogGraphQLAPI.repository;

import RestAPI.DogGraphQLAPI.entity.Dog;
import org.springframework.data.repository.CrudRepository;

public interface DogRepository extends CrudRepository<Dog, Long> {}

