package christmas;

import camp.nextstep.edu.missionutils.test.NsTest;
import christmas.input.OrderInput;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class OrderInputTest extends NsTest {
    private static OrderInput orderInput;

    @DisplayName("주문 입력: -로 메뉴와 수량을 구분하지 않았을 때")
    @Test
    void nonDashOrder() {
        String input = "양송이수프1";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("주문 입력: ,로 각 세트를 구분하지 않았을 때")
    @Test
    void nonCommaOrder() {
        String input = "타파스-2 시저샐러드-3";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("주문 입력: 수량이 0일 때")
    @Test
    void zeroQuantity() {
        String input = "티본스테이크-0,바비큐립-1";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("주문 입력: 중복 메뉴")
    @Test
    void duplicatedMenu() {
        String input = "해산물파스타-1,크라스마스파스타-2,해산물파스타-3";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("주문 입력: 수량 20 초과")
    @Test
    void tooMany() {
        String input = "초코케이크-10,아이스크림-10,제로콜라-10,레드와인-10";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }
    
    @DisplayName("주문 입력: 음료만 주문")
    @Test
    void onlyDrink() {
        String input = "샴페인-10";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("주문 입력: 메뉴판에 없는 메뉴 주문")
    @Test
    void notFromMenu() {
        String input = "닭칼국수-1";

        assertSimpleTest(() -> {
            runException(input);
            assertThat(output())
                .contains("[ERROR]");
        });
    }

    @DisplayName("주문 입력: 정상")
    @Test
    void plainInput() {
        String input = "크리스마스파스타-1,레드와인-1";

        assertSimpleTest(() -> {
            run(input);
            assertThat(output());
        });
    }

    @Override
    public void runMain() {
        orderInput = new OrderInput();
        orderInput.order();
    }
}
