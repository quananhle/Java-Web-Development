package Entity;
//A Flower for the company to sell
import javax.persistence.*;

@Entity
//Flowers will be stored in a table called ‘plant’
@Table(name="plant")
public class Flower extends Plant{
    private String color;

    //setter and getter
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

}
