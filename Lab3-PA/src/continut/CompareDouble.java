package continut;

import java.util.Comparator;

import java.util.Comparator;

/**
 * Clasa ce implementeaza o comparatie intre 2 obiecte
 * Este folosita pentru a sorta dupa profitul fiecarui item
 */
public class CompareDouble implements Comparator<Item> {
    public int compare(Item i1, Item i2) {
        if (i1.profitFactor() == i2.profitFactor()) {
            return 0;
        }
        if (i1.profitFactor() > i2.profitFactor()) {
            return -1;
        }
        return 1;
    }
}
