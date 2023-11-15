package christmas.order;

import java.util.Map;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import christmas.constant.Constants;
import christmas.constant.EventType;
import christmas.constant.Menu;
import christmas.io.Date;

public class EventData {
    private Map<EventType, Integer> eventData = new EnumMap<>(EventType.class);

    public void evalData(Order order, Date date) {
        xmas(date.getDate());
        weekday(order.getOrder(), date.getDay());
        weekend(order.getOrder(), date.getDay());
        special(date.getDate(), date.getDay());
        gift(order.getTotal());
    }

    private void xmas(int date) {
        if (date <= Constants.XMASLIMIT) {
            this.eventData.put(EventType.XMAS, EventType.XMAS.getCost(date));
        }
    }

    private void weekday(Map<Menu, Integer> order, String day) {
        Set<String> days = new HashSet<>(Constants.WEEKDAY);
        if (!days.contains(day)) {
            return;
        }
        int total = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            if (entry.getKey().getType().equals(Constants.WEEKDAYCRITERIA)) {
                total += EventType.WEEKDAY.getCost() * entry.getValue();
            }
        }
        if (total != 0) {
            this.eventData.put(EventType.WEEKDAY, total);
        }
    }

    private void weekend(Map<Menu, Integer> order, String day) {
        Set<String> days = new HashSet<>(Constants.WEEKEND);
        if (!days.contains(day)) {
            return;
        }
        int total = 0;
        for (Map.Entry<Menu, Integer> entry : order.entrySet()) {
            if (entry.getKey().getType().equals(Constants.WEEKENDCRITERIA)) {
                total += EventType.WEEKEND.getCost() * entry.getValue();
            }
        }
        if (total != 0) {
            this.eventData.put(EventType.WEEKEND, total);
        }
    }

    private void special(int date, String day) {
        if (day.equals(Constants.STARDAY) || date == Constants.STARDATE) {
            this.eventData.put(EventType.SPECIAL, EventType.SPECIAL.getCost());
        }
    }

    private void gift(int cost) {
        if (cost < Constants.GIFTCRITERIA) {
            return;
        }
        this.eventData.put(EventType.GIFT, EventType.GIFT.getCost());
    }

    public Map<EventType, Integer> getData() {
        return this.eventData;
    }
}
