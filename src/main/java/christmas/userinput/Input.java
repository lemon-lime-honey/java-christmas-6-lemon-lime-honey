package christmas.userinput;

import christmas.order.Order;

public class Input {
    private Date date = new Date();
    private OrderInput orderInput = new OrderInput();
    private Order order;

    public void run() {
        date.saveDate();
        this.order = orderInput.order();
    }

    public Date getDate() {
        return this.date;
    }

    public Order getOrder() {
        return this.order;
    }
}