package christmas.event;

public class Christmas {
    public int discount(int date) {
        if (date > 26) {
            return 0;
        }
        return 900 + 100 * date;
    }
}
