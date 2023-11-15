package christmas.output;

import java.util.Map;

import christmas.event.Badge;
import christmas.event.Event;
import christmas.event.EventData;
import christmas.event.EventType;
import christmas.input.Date;
import christmas.input.Message;
import christmas.order.Menu;
import christmas.order.Order;

public class Output {
    private Event event = new Event();
    Map<EventType, Integer> data;

    public void run(Order order, Date date) {
        System.out.println(Message.PREVIEW.getMessage(date.getDate()));
        printOrder(order.getOrder());
        printBefore(order);
        event.eventRunner(date, order);
        data = event.getEventData().getData();
        printGift();
        printBenefit();
        printTotalBenefit();
        printAfter();
        printBadge();
    }

    private void printOrder(Map<Menu, Integer> order) {
        System.out.println();
        System.out.println(Message.ORDERED_MENU.getMessage());
        for (Map.Entry<Menu, Integer> entry: order.entrySet()) {
            System.out.println(Message.ORDER_DETAIL.getMessage(entry.getKey().getName(), entry.getValue()));
        }
    }

    private void printBefore(Order order) {
        System.out.println();
        System.out.println(Message.TOTAL_COST_BEFORE.getMessage());
        System.out.println(Message.COST.getMessage(order.getTotal(), false));
    }

    private void printGift() {
        System.out.println();
        System.out.println(Message.GIFT_MESSAGE.getMessage());
        if (data.containsKey(EventType.GIFT)) {
            System.out.println(Message.GIFT.getMessage(Menu.GIFT.getName(), 1));
            return;
        }
        System.out.println(Message.NONE.getMessage());
    }

    private void printBenefit() {
        System.out.println();
        System.out.println(Message.BENEFIT_MESSAGE.getMessage());
        if (data.size() == 0) {
            System.out.println(Message.NONE.getMessage());
            return;
        }
        for (Map.Entry<EventType, Integer> entry: data.entrySet()) {
            System.out.println(Message.BENEFIT.getMessage(entry.getKey().getName(), entry.getValue()));
        }
    }

    private void printTotalBenefit() {
        System.out.println();
        System.out.println(Message.TOTAL_BENEFIT_MESSAGE.getMessage());
        System.out.println(Message.COST.getMessage(event.getDiscount(), true));
    }

    private void printAfter() {
        System.out.println();
        System.out.println(Message.TOTAL_COST_AFTER.getMessage());
        System.out.println(Message.COST.getMessage(event.getAfterCost(), false));
    }

    private void printBadge() {
        System.out.println();
        System.out.println(Message.BADGE.getMessage());
        System.out.println(event.getBadge().getName());
    }
}
