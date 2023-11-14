package christmas.order;

import java.util.EnumMap;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> order = new EnumMap<>(Menu.class);
    private int totalCost;

    public void saveOrder(Menu menu, int quantity) {
        if (order.containsKey(menu)) {
            order.put(menu, order.get(menu) + quantity);
            return;
        }
        order.put(menu, quantity);
    }

    public void calculate() {
        this.totalCost = 0;

        for (Map.Entry<Menu, Integer> entry: order.entrySet()) {
            this.totalCost += entry.getKey().getCost() * entry.getValue();
        }
    }

    public int getTotal() {
        return this.totalCost;
    }

    public Map<Menu, Integer> getOrder() {
        return this.order;
    }
}
