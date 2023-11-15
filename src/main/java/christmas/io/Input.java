package christmas.io;

import christmas.order.Order;

public class Input {
    private Date date = new Date();
    private OrderInput orderInput = new OrderInput();
    private Order order;

    public boolean run() {
        if (!date.setDate())
            return false;
        if (!orderInput.order())
            return false;
        this.order = orderInput.getOrder();
        return true;
    }

    public Date getDate() {
        return this.date;
    }

    public Order getOrder() {
        return this.order;
    }
}
