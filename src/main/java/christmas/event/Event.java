package christmas.event;

import java.util.Map;

import christmas.order.Order;
import christmas.order.Menu;
import christmas.userinput.Date;

public class Event {
    private static Christmas xmas = new Christmas();
    private static Weekday weekday = new Weekday();
    private static Weekend weekend = new Weekend();
    private static Special special = new Special();
    private static Gift gift = new Gift();
    private boolean present = false;
    private Badge badge;
    private int discountCost;
    private int money;

    private void discount(Date date, Order order) {
        int result = 0;
        if (canRun(order)) {
            result += xmas.discount(date.getDate());
            result += weekday.discount(order.getOrder(), date.getDay());
            result += weekend.discount(order.getOrder(), date.getDay());
            result += special.discount(date.getDate(), date.getDay());
        }
        this.discountCost = result;
    }

    private boolean canRun(Order order) {
        if (order.getTotal() < 10000) {
            return false;
        }
        return true;
    }

    private void afterDiscount(Date date, Order order) {
        this.money = order.getTotal() - this.discountCost;
    }

    private void checkGift(Order order) {
        this.present = gift.getGift(order.getTotal());
    }

    private void badge(Order order) {
        int value = this.discountCost;
        if (this.present) {
            value += Menu.CHAMPAGNE.getCost();
        }
        this.badge = this.badge.findByLimit(value);
    }

    public int getDiscount() {
        return this.discountCost;
    }

    public int getAfterCost() {
        return this.money;
    }

    public Badge getBadge() {
        return this.badge;
    }

    public void eventRunner(Date date, Order order) {
        order.calculate();
        discount(date, order);
        afterDiscount(date, order);
        checkGift(order);
        badge(order);
    }
}
