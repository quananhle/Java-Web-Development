package Entitites;
//A Flower for the company to sell
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
//Flowers will be stored in a table called ‘plant’
@Table(name="plant")
public class Flower {
    @Id
    @GeneratedValue
    private Long id;
    @Nationalized                      //the flower names support international language characters
    private String name;
    private String color;
    @Column(precision=12, scale=4)     //price is stored as a DECIMAL column with 12 precision and 4 decimal places
    private BigDecimal price;

    //non-default constructor
    public Flower(Long id, String name, String color, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.price = price;
    }

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

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
