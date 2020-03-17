package continut;

/**
 * Interfata obiectelor
 */
public interface Item extends Comparable<Item> {
    /**
     * Getter
     */
    String getName();

    /**
     * Getter
     */
    double getValue();

    /**
     * Getter
     */
    double getWeight();

    /**
     * Calculeaza profitul fiecarui obiect din lista
     */
    default double profitFactor() {
        return getValue() / getWeight();
    }

    /**
     * Compara obiectele intre ele
     */
    @Override
    default int compareTo(Item o) {
        return getName().compareTo(o.getName());
    }


}