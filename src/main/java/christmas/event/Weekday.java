package christmas.event;

import christmas.order.Menu;

import java.util.EnumMap;

public class Weekday {
    public int discount(EnumMap<Menu, Integer> order) {
        int result = 0;
        for (Menu menu: order.keySet()) {
            if (menu.getType().equals("디저트")) {
                result += 2023;
            }
        }
        return result;
    }
}
