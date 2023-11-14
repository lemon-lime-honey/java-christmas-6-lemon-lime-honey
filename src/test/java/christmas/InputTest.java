package christmas;

import christmas.userinput.Input;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class InputTest extends NsTest {
    private static Input input;
    private static final String stop = "20";

    @DisplayName("날짜 입력: 범위를 벗어나는 숫자를 입력했을 때")
    @Test
    void dateInputOneToThirtyOne() {
        String input = "32";

        assertSimpleTest(() -> {
            run(input, stop);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("날짜 입력: 문자를 입력했을 때")
    @Test
    void dateInputLetter() {
        String input = "Anakin";

        assertSimpleTest(() -> {
            run(input, stop);
            assertThat(output()
                .contains("[ERROR]"));
        });
    }

    @Override
    public void runMain() {
        input = new Input();
        input.run();
    }
}
