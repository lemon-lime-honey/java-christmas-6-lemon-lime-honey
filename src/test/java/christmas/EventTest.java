package christmas;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import christmas.constant.Menu;
import christmas.io.Date;
import christmas.order.Event;
import christmas.order.Order;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

class EventTest {
    static Date date;
    static Order order;
    static Event event;

    @DisplayName("이벤트: 주문 금액 만 원 미만")
    @Test
    void lessThanTenThousand() {
        util(25, Menu.TAPAS, 1, Menu.COKE, 1);

        assertThat(event.getAfterCost()).isEqualTo(order.getTotal());
    }

    @DisplayName("이벤트: 크리스마스, 평일, 증정")
    @Test
    void xmaxWeekday() {
        util(21, Menu.CAKE, 2, Menu.STEAK, 2);

        assertThat(event.getDiscount()).isEqualTo(3000+4046+25000);
        assertThat(event.getBadge().getName()).isEqualTo("산타");
    }

    @DisplayName("이벤트: 주말")
    @Test
    void weekend() {
        util(30, Menu.RIBS, 1, Menu.CHAMPAGNE, 1);

        assertThat(event.getDiscount()).isEqualTo(2023);
        assertThat(event.getBadge().getName()).isEqualTo("없음");
    }

    @DisplayName("이벤트: 크리스마스 당일")
    @Test
    void xmasDDay() {
        util(25, Menu.STEAK, 3, Menu.CAKE, 3);

        assertThat(event.getDiscount()).isEqualTo(3400+6069+1000+Menu.GIFT.getCost());
        assertThat(event.getAfterCost()).isEqualTo(Menu.STEAK.getCost() * 3 + Menu.CAKE.getCost() * 3 - 3400 - 6069 - 1000);
        assertThat(event.getBadge().getName()).isEqualTo("산타");
    }

    void util(int number, Menu menu1, int quantity1, Menu menu2, int quantity2) {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        InputStream in = new ByteArrayInputStream(Integer.toString(number).getBytes());
        System.setIn(in);
        date.setDate();
        Console.close();
        order.saveOrder(menu1, quantity1);
        order.saveOrder(menu2, quantity2);
        order.calculate();
        event.eventRunner(date, order);
    }

    @BeforeEach
    void run() {
        date = new Date();
        order = new Order();
        event = new Event();
    }
}
