package Entitites;

import org.hibernate.annotations.Nationalized;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="" )
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

    //non-default constructor
    public Delivery(Long id, String name, String address, LocalDateTime deliveryTime, boolean completed) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.deliveryTime = deliveryTime;
        this.completed = completed;
    }

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
}
