package christmas;

import christmas.input.Input;
import christmas.output.Output;

public class Application {
    private static Input input = new Input();
    private static Output output = new Output();

    public static void main(String[] args) {
        if (!input.run()) return;
        output.run(input.getOrder(), input.getDate());
    }
}
