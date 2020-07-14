package RestAPI.DogGraphQLAPI.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
/**
 * @Entity:	This marks a Java class as an entity, which means it will be persisted
 * to the database. Typically, an entity maps to a database table and the table
 * contains rows that represent that given entity.
 **/
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;
    /**
     * The dog have three attributes:
     *     Name
     *     Breed
     *     Origin
     **/
    private String name;
    private String breed;
    private String origin;

    public Dog(Long id, String name, String breed, String origin) {
        this.ID = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    public Dog() {}

    public Long getId() {
        return ID;
    }

    public void setId(Long id) {
        this.ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
