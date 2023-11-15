package christmas.constant;

public enum EventType {
    XMAS("크리스마스 디데이 할인", 900),
    WEEKDAY("평일 할인", 2023),
    WEEKEND("주말 할인", 2023),
    SPECIAL("특별 할인", 1000),
    GIFT("증정 이벤트", Menu.GIFT.getCost());

    private final String name;
    private final int cost;

    EventType(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public int getCost() {
        return this.cost;
    }

    public int getCost(int date) {
        return this.cost + 100 * date;
    }
}
