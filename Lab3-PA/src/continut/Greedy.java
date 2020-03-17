package continut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clasa ce defineste algoritmul de adaugare al itemelor intr-un sac dupa profit
 */
public class Greedy implements Algorithm {
    private Knapsack sac;
    private List<Item> items;

    /**
     * Contructor
     */
    Greedy(List<Item> items) {
        this.sac = new Knapsack(10.0);
        this.items = items;
    }

    /**
     * Functia ce rezolva prin algoritmul greedy problema propusa
     * Aceasta creeaza o lista noua de iteme permise in sac
     * Sorteaza itemele din lista itemelor posibile
     * Adauga in sac printr-un for in ordinea sortata atat timp cat nu depaseste capacitatea sacului
     */
    public void rezolva() {
        Collections.sort(items, new CompareDouble());
        List<Item> ListaPermisa = new ArrayList<>();
        double capacitatesac = 0.0;
        for (Item i : items)
            if (i.getWeight() + capacitatesac <= sac.getCapacity()) {
                ListaPermisa.add(i);
                capacitatesac += i.getWeight();
            }
        sac.setItems(ListaPermisa);
    }

    /**
     * Getter
     */
    public Knapsack getSac() {
        return sac;
    }

    /**
     * Setter
     */
    public void setSac(Knapsack sac) {
        this.sac = sac;
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
}
