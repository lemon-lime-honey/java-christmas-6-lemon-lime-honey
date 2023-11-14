package christmas.order;

import christmas.userinput.Error;

import java.util.EnumMap;

public class Order {
    private EnumMap<Menu, Integer> order = new EnumMap<>(Menu.class);

    public void saveOrder(Menu menu, int quantity) {
        if (order.containsKey(menu)) {
            throw new IllegalArgumentException(Error.MENU_DUPLICATE.getMessage());
        }
        order.put(menu, quantity);
    }
}
