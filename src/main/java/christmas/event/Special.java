package christmas.event;

public class Special {
    public int discount(int date, String day) {
        if (day.equals("일") || date == 25) {
            return 1000;
        }
        return 0;
    }
}
