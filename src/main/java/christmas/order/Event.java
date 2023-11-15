package christmas.order;

import java.util.Map;

import christmas.enums.Badge;
import christmas.enums.EventType;
import christmas.enums.Menu;
import christmas.io.Date;

public class Event {
    private static final int eventCostLimit = 10000;
    private EventData eventData = new EventData();
    private Badge badge;
    private int discount = 0;
    private int discounted;

    private void runDiscount(Date date, Order order) {
        if (canRun(order)) {
            eventData.evalData(order, date);
        }
        for (Map.Entry<EventType, Integer> entry : eventData.getData().entrySet()) {
            this.discount += entry.getValue();
        }
    }

    private boolean canRun(Order order) {
        if (order.getTotal() < eventCostLimit)
            return false;
        return true;
    }

    private void afterDiscount(Order order) {
        this.discounted = order.getTotal() - this.discount;
        if (eventData.getData().containsKey(EventType.GIFT)) {
            this.discounted += Menu.GIFT.getCost();
        }
    }

    private void badge(Order order) {
        int value = this.discount;
        if (this.eventData.getData().containsKey(EventType.GIFT)) {
            value += Menu.GIFT.getCost();
        }
        this.badge = findBadge(value);
    }

    private Badge findBadge(int value) {
        Badge result = Badge.NONE;
        for (Badge badge : Badge.values()) {
            if (value > badge.getLimit()) {
                result = badge;
                break;
            }
        }
        return result;
    }

    public int getDiscount() {
        return this.discount;
    }

    public int getAfterCost() {
        return this.discounted;
    }

    public Badge getBadge() {
        return this.badge;
    }

    public EventData getEventData() {
        return this.eventData;
    }

    public void eventRunner(Date date, Order order) {
        runDiscount(date, order);
        afterDiscount(order);
        badge(order);
    }
}
