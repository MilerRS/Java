package continut;

/**
 * Clasa ce defineste un tip de item din sac
 */
public class Food implements Item {
    private String name;
    private double weight; // → getWeight, getValue

    /**
     * Contructor
     */
    public Food(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Getter
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Getter
     */
    @Override
    public double getValue() {
        return weight * 2;
    }

    /**
     * Setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     */
    @Override
    public double getWeight() {
        return weight;
    }

    /**
     * Setter
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Calculeaza profitul fiecarui obiect din lista
     */
    @Override
    public double profitFactor() {
        return getValue() / getWeight();
    }

    /**
     * Afiseaza continutul unui sac
     */
    @Override
    public String toString() {
        return "\nFood: " + this.getName() + ", weight= " + this.getWeight() + ", value= " + this.getValue() + " ( " + "profit factor= " + this.profitFactor() + " )";
    }
}
