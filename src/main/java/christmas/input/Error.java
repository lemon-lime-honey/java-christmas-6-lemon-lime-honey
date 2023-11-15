package christmas.input;

public enum Error {
    DATE_NOT_A_NUMBER("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    DATE_WRONG_NUMBER("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    MENU_NOT_EXIST("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_NOT_A_NUMBER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_WRONG_NUMBER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_WRONG_STYLE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_DUPLICATE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_TOO_MANY("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    MENU_ONLY_DRINK("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
