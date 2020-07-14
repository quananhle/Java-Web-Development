package RestAPI.MicroserviceEureka.DogMicroservice.entity;

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
     *     Owner
     **/
    private String name;
    private String breed;
    private String origin;
    private String owner;

    //non-default constructors
    public Dog(Long generatedID, String dogName, String dogBreed, String dogOrigin, String dogOwner) {
        this.ID = generatedID;
        this.name = dogName;
        this.breed = dogBreed;
        this.origin = dogOrigin;
        this.owner = dogOwner;
    }
    public Dog(String dogName, String dogBreed) {
        this.name = dogName;
        this.breed = dogBreed;
    }
    //default constructor
    public Dog() {}

    //setter and getter methods
    public void setID(Long ID) {
        this.ID = ID;
    }
    public Long getID() {
        return ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public String getBreed() {
        return breed;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getOwner() {
        return owner;
    }
}

