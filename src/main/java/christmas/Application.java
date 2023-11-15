package christmas;

import christmas.output.Output;
import christmas.userinput.Input;

public class Application {
    private static Input input = new Input();
    private static Output output = new Output();

    public static void main(String[] args) {
        if (!input.run()) return;
        output.run(input.getOrder(), input.getDate());
    }
}
