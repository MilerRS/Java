package continut;

/**
 * Clasa ce defineste un tip de item din sac
 */
public class Book implements Item {
    private String name;
    private int pageNumber; //→ getWeight
    private double value;

    /**
     * Contructor
     */
    public Book(String name, int pageNumber, double value) {
        this.name = name;
        this.pageNumber = pageNumber;
        this.value = value;
    }

    /**
     * Setter
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter
     */
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Getter
     */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * Getter
     */
    @Override
    public double getWeight() {
        return pageNumber / 100;
    }

    /**
     * Getter
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Calculeaza profitul fiecarui obiect din lista
     */
    @Override
    public double profitFactor() {
        return getValue() / getWeight();
    }

    /**
     * Afiseaza continutul unei carti
     */
    @Override
    public String toString() {
        return "\nBook: " + this.getName() + ", weight= " + this.getWeight() + ", value= " + this.getValue() + " ( " + "profit factor= " + this.profitFactor() + " )";
    }
}
