package continut;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clasa ce defineste un tip de item din sac
 */
public class Weapon implements Item {
    private WeaponType type;
    private double weight;
    private double value;
    //...constructor
//...getters and setters

    public enum WeaponType {
        Spear, Sword, Hammer, Axe, Crossbow, Bow, Bolt, Catapulte;
    }

    /**
     * Contructor
     */
    public Weapon(WeaponType type, double weight, double value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    /**
     * Getter
     */
    public WeaponType getType() {
        return type;
    }

    /**
     * Setter
     */
    public void setType(WeaponType type) {
        this.type = type;
    }

    /**
     * Setter
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Setter
     */
    public void setValue(double value) {
        this.value = value;
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
        return weight;
    }

    /**
     * Getter
     */
    @Override
    public String getName() {
        return type.name();
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
        return "\nWeapon: " + this.getName() + ", weight= " + this.getWeight() + ", value= " + this.getValue() + " ( " + "profit factor= " + this.profitFactor() + " )";
    }

}
