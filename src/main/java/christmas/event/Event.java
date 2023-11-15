package christmas.event;

import java.util.Map;

import christmas.order.Order;
import christmas.order.Menu;
import christmas.userinput.Date;

public class Event {
    private EventData eventData = new EventData();
    private Badge badge;
    private int discount = 0;
    private int discounted;

    private void runDiscount(Date date, Order order) {
        if (canRun(order)) {
            eventData.evalData(order, date);
        }
        for (Map.Entry<EventType, Integer> entry: eventData.getData().entrySet()) {
            this.discount += entry.getValue();
        }
    }

    private boolean canRun(Order order) {
        if (order.getTotal() < 10000) {
            return false;
        }
        return true;
    }

    private void afterDiscount(Date date, Order order) {
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
        for (Badge badge: Badge.values()) {
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
        afterDiscount(date, order);
        badge(order);
    }
}
