package christmas.enums;

public enum Badge {
    SANTA("산타", 20000),
    TREE("트리", 10000),
    STAR("별", 5000),
    NONE("없음", 0);

    private final String name;
    private final int limit;

    Badge(String name, int limit) {
        this.name = name;
        this.limit = limit;
    }

    public String getName() {
        return this.name;
    }

    public int getLimit() {
        return this.limit;
    }
}
