package christmas.io;

import camp.nextstep.edu.missionutils.Console;
import christmas.enums.Error;
import christmas.enums.Message;

public class Date {
    private int date;
    private String day;
    private String[] days = {"목", "금", "토", "일", "월", "화", "수"};

    public boolean setDate() {
        System.out.println(Message.INIT.getMessage());
        return saveDate();
    }

    private boolean dateInput() {
        String ipt = Console.readLine();
        try {
            if (ipt.isBlank())
                return false;
            this.date = Integer.parseInt(ipt);
            if (this.date < 1 || this.date > 31) {
                throw new IllegalArgumentException(Error.DATE_WRONG_NUMBER.getMessage());
            }
            return true;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Error.DATE_NOT_A_NUMBER.getMessage());
        }
    }

    private boolean saveDate() {
        while (true) {
            try {
                dateInput();
                setDay();
                return true;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setDay() {
        this.day = days[this.date % 7];
    }

    public int getDate() {
        return this.date;
    }

    public String getDay() {
        return this.day;
    }
}