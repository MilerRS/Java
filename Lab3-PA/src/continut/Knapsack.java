package continut;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clasa pentru sacul care contine o capacitate si o lista de obiecte incluse in el
 */
public class Knapsack {
    private double capacity;
    private List<Item> items = new ArrayList<>();

    /**
     * Contructor
     */
    public Knapsack(double capacity, List<Item> items) {
        this.capacity = capacity;
        this.items = items;
    }

    /**
     * Constructor
     */
    public Knapsack(double capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Setter
     */
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    /**
     * Getter
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * Setter
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    /**
     * Adauga iteme in lista de obiecte
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Afiseaza continutul unui sac
     */
    @Override
    public String toString() {
        String s = new String();

        s += "capacity of the knapsack = ";
        s += capacity;
        s += "\navailable items:";
        for (Item c : items)
            s += c;

        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knapsack)) return false;
        Knapsack knapsack = (Knapsack) o;
        return Double.compare(knapsack.getCapacity(), getCapacity()) == 0 &&
                getItems().equals(knapsack.getItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCapacity(), getItems());
    }
}