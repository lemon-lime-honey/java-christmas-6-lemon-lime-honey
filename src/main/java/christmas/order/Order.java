package christmas.order;

import java.util.EnumMap;

public class Order {
    private EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);

    public void saveOrder(Menu menu, int quantity) {
        if (order.containsKey(menu)) {
            order.put(menu, order.get(menu) + quantity);
            return;
        }
        order.put(menu, quantity);
    }
}
