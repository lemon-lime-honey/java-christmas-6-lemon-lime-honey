package christmas.event;

public class Gift {
    public boolean getGift(int cost) {
        if (cost < 120000) return false;
        return true;
    }
}
