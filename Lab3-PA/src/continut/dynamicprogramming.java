package continut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clasa ce defineste algoritmul de adaugare al unor iteme intr-un sac dupa greutatea permisa
 */
public class dynamicprogramming implements Algorithm {
    private Knapsack sac;
    private List<Item> items;
    private int capacity;

    /**
     * Contructor
     */
    public dynamicprogramming(List<Item> items, int capacity) {
        this.items = items;
        this.capacity = capacity;
        this.sac = new Knapsack(capacity);
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

    /**
     * Getter
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Setter
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Functia ce implementeaza algoritmul:
     * 1.Creeaza 2 vectori pentru greutate, respectiv valori ale itemelor din sac
     * 2.Adauga in cei 2 vectori valorile respective pentru fiecare item in parte
     * 3.Creeaza o matrice dupa nr de iteme si greutatea lor, instantiind primul rand cu 0
     * 4.Se modifica matricea astfel incat pe ultima pozitie se ajunge cu greutatea maxima posibila cu itemele disponibile mai mici decat greutatea sacului
     * 5.Se adauga in sac iteme atat timp cat nu depasesc greutatea sacului
     */
    public void rezolva() {
        int nbItems = items.size();
        int[] w = new int[items.size()];
        int[] v = new int[items.size()];
        int contor = 0;
        for (Item i : items) {
            w[contor] = (int) i.getWeight();
            v[contor] = (int) i.getValue();
            contor++;
        }

        int[][] matrix = new int[nbItems + 1][capacity + 1];

        for (int i = 0; i <= capacity; i++)
            matrix[0][i] = 0;


        for (int i = 1; i <= nbItems; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (w[i - 1] > j)
                    matrix[i][j] = matrix[i - 1][j];
                else
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - w[i - 1]]
                            + v[i - 1]);
            }
        }

        int res = matrix[nbItems][capacity];
        int W = capacity;
        List<Item> SelectedItems = new ArrayList<>();

        for (int i = nbItems; i > 0 && res > 0; i--) {
            if (res != matrix[i - 1][W]) {
                SelectedItems.add(items.get(i - 1));
                res -= v[i - 1];
                W -= w[i - 1];
            }
        }
        sac.setItems(SelectedItems);
        ;
    }
}