package christmas.userinput;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public void run() {
        System.out.println(Message.INIT.getMessage());
        int date = loopDateInput();
    }

    private int runDateInput() {
        String ipt = Console.readLine();
        try {
            int date = Integer.parseInt(ipt);
            if (date < 1 || date > 31) {
                throw new IllegalArgumentException(Error.DATE_WRONG_NUMBER.getMessage());
            }
            return date;
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Error.DATE_NOT_A_NUMBER.getMessage());
        }
    }

    private int loopDateInput() {
        while (true) {
            try {
                return runDateInput();
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
