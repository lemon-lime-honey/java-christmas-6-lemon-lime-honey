package christmas.userinput;

import java.text.DecimalFormat;

public enum Message {
    INIT("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.\n12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
    ORDER("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
    PREVIEW("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDERED_MENU("<주문 메뉴>"),
    ORDER_DETAIL("%s %d개"),
    TOTAL_COST_BEFORE("<할인 전 총주문 금액>"),
    GIFT_MESSAGE("<증정 메뉴>"),
    GIFT("%s %d개"),
    BENEFIT_MESSAGE("<혜택 내역>"),
    BENEFIT("%s: -%s원"),
    TOTAL_BENEFIT_MESSAGE("<총혜택 금액>"),
    TOTAL_COST_AFTER("<할인 후 예상 결제 금액>"),
    COST("%s원"),
    BADGE("12월 이벤트 배지"),
    NONE("없음");

    private final String message;
    private static final DecimalFormat df = new DecimalFormat("###,###");
    private static final String minus = "-";

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessage(int quantity) {
        return String.format(message, quantity);
    }

    public String getMessage(String name, int number) {
        if (number < 21) {
            return String.format(message, name, number);
        }
        return String.format(message, name, df.format(number));
    }

    public String getMessage(int cost, boolean flag) {
        if (!flag || cost == 0) {
            return String.format(message, df.format(cost));
        }
        return minus + String.format(message, df.format(cost));        
    }
}
