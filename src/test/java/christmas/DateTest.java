package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.input.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class DateTest extends NsTest {
    private static Date date;

    @DisplayName("날짜 입력: 범위를 벗어나는 숫자를 입력했을 때")
    @Test
    void dateInputOneToThirtyOne() {
        String input = "32";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("날짜 입력: 문자를 입력했을 때")
    @Test
    void dateInputLetter() {
        String input = "Anakin";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output()
                .contains("[ERROR]"));
        });
    }

    @Override
    public void runMain() {
        date = new Date();
        date.setDate();
    }
}
