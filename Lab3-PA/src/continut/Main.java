package continut;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Clasa principala unde se instantiaza obiecte din lista de iteme sacul care contine obiecte si afiseaza sacul tot cu continut
 */
public class Main {
    static List<Item> items = new ArrayList<>();

    public static void main(String[] args) {

        Weapon weapon = new Weapon(Weapon.WeaponType.Sword, 5, 10);

        Food food1 = new Food("Cabbage", 2);
        Food food2 = new Food("Rabbit", 2);

        Book book1 = new Book("Dragon Rising", 300, 5);
        Book book2 = new Book("A Blade in the Dark", 300, 5);
        items.add(food1);
        items.add(food2);
        items.add(book1);
        items.add(book2);
        items.add(weapon);

        Collections.sort(items, Item::compareTo);

        Knapsack k1 = new Knapsack(10.0, items);

        System.out.println(k1);
        System.out.println();

        Greedy Greed = new Greedy(items);
        Greed.rezolva();

        System.out.println(Greed.getSac());
        System.out.println();

        dynamicprogramming DP = new dynamicprogramming(items, 10);
        DP.rezolva();

        System.out.println(DP.getSac());
        System.out.println();
    }
}
