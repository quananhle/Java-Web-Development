package Entity;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(name="Delivery.findByName", query="select d from Delivery d where d.name = :name" )
@Entity
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;
    @Nationalized                                        //the recipient names support international language characters
    private String name;
    @Column(name="address_full", length=500)             //address in a single field, column will be wide enough to hold up to 500 characters
    private String address;
    private LocalDateTime deliveryTime;
    @Type(type="yes_no")                                 //show up as ‘Y’ or ‘N’ in the database if completed
    private boolean completed;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "delivery", cascade = CascadeType.ALL)
    private List<Plant> plants;

    //getter and setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }
    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public List<Plant> getPlants() {
        return plants;
    }
    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }
}
