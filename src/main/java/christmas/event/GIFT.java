package christmas.event;

public class GIFT {
    public boolean getGift(int cost) {
        if (cost < 120000) return false;
        return true;
    }
}
