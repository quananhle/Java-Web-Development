package Entity;
// Uses InheritanceType.JOINED to store shared fields in 'plant' and unique fields in subclass tables

import View.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//Create a new parent class called Plant that contains the shared attributes of name, price, and id.
public class Plant {
    @Id
    @GeneratedValue
    private Long id;
    @JsonView(Views.Public.class)       //getFilteredPlant only returns name
    @Nationalized                       //the plant names support international language characters
    private String name;
    @JsonView(Views.Public.class)       //getFilteredPlant only returns price
    @Column(precision=12, scale=4)      //price is stored as a DECIMAL column with 12 precision and 4 decimal places
    private BigDecimal price;

    @ManyToOne                          //many plants can be in one delivery
    @JoinColumn(name="delivery_id")     //map the join column in the plant table
    private Delivery delivery;

    //setter and getter
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

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Delivery getDelivery() {
        return delivery;
    }
    public void setDelivery(String color) {
        this.delivery = delivery;
    }

}
