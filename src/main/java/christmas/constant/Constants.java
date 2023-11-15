package christmas.constant;

import java.util.List;

public final class Constants {
    public static final List<String> DAYS = List.of("목", "금", "토", "일", "월", "화", "수");
    public static final List<String> WEEKDAY = List.of("일", "월", "화", "수", "목");
    public static final List<String> WEEKEND = List.of("금", "토");

    public static final int EVENTCOSTCRITERIA = 10000;
    public static final int GIFTCRITERIA = 120000;
    public static final int QUANTITYLIMIT = 20;
    public static final int STARDATE = 25;
    public static final int XMASLIMIT = 25;

    public static final String MENUCRITERIA = "음료";
    public static final String MENUSETPATTERN = "^[가-힣]+-[0-9]+$";
    public static final String STARDAY = "일";
    public static final String WEEKDAYCRITERIA = "디저트";
    public static final String WEEKENDCRITERIA = "메인";
}
