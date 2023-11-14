package christmas.event;

import christmas.order.Menu;

import java.util.Arrays;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Weekend {
    public int discount(Map<Menu, Integer> order, String day) {
        Set<String> days = new HashSet<>(Arrays.asList("금", "토"));
        if (!days.contains(day)) return 0;

        int result = 0;
        for (Menu menu: order.keySet()) {
            if (menu.getType().equals("메인")) {
                result += 2023;
            }
        }
        return result;
    }
}
