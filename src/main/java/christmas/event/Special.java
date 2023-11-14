package christmas.event;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Special {
    public int discount(int date) {
        Set<Integer> star = new HashSet<>(Arrays.asList(3, 10, 17, 24, 25, 31));
        if (star.contains(date)) {
            return 1000;
        }
        return 0;
    }
}
