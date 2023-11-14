package christmas.order;

import java.util.NoSuchElementException;
import christmas.userinput.Error;

public enum Menu {
    SOUP("애피타이저", "양송이수프", 6000),
    TAPAS("애피타이저", "타파스", 5500),
    SALAD("애피타이저", "시저샐러드", 8000),
    STEAK("메인", "티본스테이크", 55000),
    RIBS("메인", "바비큐립", 54000),
    SEAFOOD_PASTA("메인", "해산물파스타", 35000),
    XMAS_PASTA("메인", "크리스마스파스타", 25000),
    CAKE("디저트", "초코케이크", 15000),
    ICECREAM("디저트", "아이스크림", 5000),
    COKE("음료", "제로콜라", 3000),
    REDWINE("음료", "레드와인", 60000),
    CHAMPAGNE("음료", "샴페인", 25000),
    GIFT("증정품", "샴페인", 25000);

    private final String type;
    private final String name;
    private final int cost;

    Menu(String type, String name, int cost) {
        this.type = type;
        this.name = name;
        this.cost = cost;
    }

    public String getType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public static Menu findByName(String value) {
        for (Menu menu: values()) {
            if (menu.getName().equals(value)) {
                return menu;
            }
        }
        throw new NoSuchElementException(Error.MENU_NOT_EXIST.getMessage());
    }
}
