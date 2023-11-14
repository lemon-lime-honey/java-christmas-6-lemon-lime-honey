package christmas.userinput;

import camp.nextstep.edu.missionutils.Console;

public class Date {
    private int date;

    private void dateInput() {
        String ipt = Console.readLine();
        try {
            this.date = Integer.parseInt(ipt);
            if (this.date < 1 || this.date > 31) {
                throw new IllegalArgumentException(Error.DATE_WRONG_NUMBER.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Error.DATE_NOT_A_NUMBER.getMessage());
        }
    }

    public void saveDate() {
        while (true) {
            try {
                dateInput();
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int getDate() {
        return this.date;
    }
}
