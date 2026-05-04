package acc2_fat;

import java.util.ArrayList;
import java.util.List;

class Item {
    int weight, value;

    public Item(int w, int v) {
        this.weight = w;
        this.value = v;
    }
}


public class KnapSack01 {
    public static int dp(ArrayList<Item> l, int i, int c) {
        if (i == l.size() || c == 0) {
            return 0;
        }
        if (l.get((i)).weight <= c) {
            return Math.max(l.get(i).value + dp(l, i + 1, c - l.get(i).weight), dp(l, i + 1, c));
        }
        return dp(l, i + 1, c);
    }

    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new Item(10, 60));
        items.add(new Item(20, 100));
        items.add(new Item(30, 120));

        int capacity = 50;

        // Sort by value/weight ratio (descending)
        items.sort((i1, i2) ->
                Double.compare(
                        (double) i2.value / i2.weight,
                        (double) i1.value / i1.weight
                )
        );

        int totalValue = 0;
        int currentWeight = 0;

        // Greedy selection
        for (Item i : items) {
            if (currentWeight + i.weight <= capacity) {
                currentWeight += i.weight;
                totalValue += i.value;
            }
        }

        System.out.println("Total value = " + totalValue);

    }
}
