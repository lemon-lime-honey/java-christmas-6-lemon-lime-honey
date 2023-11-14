package christmas;

import christmas.userinput.Input;
import christmas.userinput.OrderInput;

public class Application {
    private static Input input = new Input();
    private static OrderInput orderInput = new OrderInput();
    public static void main(String[] args) {
        input.run();
        orderInput.order();
    }
}
