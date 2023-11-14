package christmas.event;

import java.util.Map;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Set;

import christmas.userinput.Date;
import christmas.order.Menu;
import christmas.order.Order;

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
        if (date < 26) {
            this.eventData.put(EventType.XMAS, 900 + 100 * date);
        }
    }

    private void weekday(Map<Menu, Integer> order, String day) {
        Set<String> days = new HashSet<>(Arrays.asList("일", "월", "화", "수", "목"));
        if (!days.contains(day)) return;

        int total = 0;
        for (Map.Entry<Menu, Integer> entry: order.entrySet()) {
            if (entry.getKey().getType().equals("디저트")) {
                total += 2023 * entry.getValue();
            }
        }
        if (total != 0) {
            this.eventData.put(EventType.WEEKDAY, total);
        }
    }

    private void weekend(Map<Menu, Integer> order, String day) {
        Set<String> days = new HashSet<>(Arrays.asList("금", "토"));
        if (!days.contains(day)) return;

        int total = 0;
        for (Map.Entry<Menu, Integer> entry: order.entrySet()) {
            if (entry.getKey().getType().equals("메인")) {
                total += 2023 * entry.getValue();
            }
        }
        if (total != 0) {
            this.eventData.put(EventType.WEEKEND, total);
        }
    }

    private void special(int date, String day) {
        if (day.equals("일") || date == 25) {
            this.eventData.put(EventType.SPECIAL, 1000);
        }
    }

    private void gift(int cost) {
        if (cost < 120000) return;
        this.eventData.put(EventType.GIFT, Menu.GIFT.getCost());
    }

    public Map<EventType, Integer> getData() {
        return this.eventData;
    }
}
