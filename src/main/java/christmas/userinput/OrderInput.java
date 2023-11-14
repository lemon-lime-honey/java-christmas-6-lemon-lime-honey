package christmas.userinput;

import camp.nextstep.edu.missionutils.Console;

import christmas.order.Menu;
import christmas.order.Order;

public class OrderInput {
    Order orderData = new Order();
    String pattern = "^[가-힣]+-[0-9]+$";

    public void order() {
        System.out.println(Message.ORDER.getMessage());
        input();
    }

    private void input() {
        while (true) {
            try {
                getInput();
                break;
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void getInput() {
        try {
            String ipt = Console.readLine();
            String[] rawData = ipt.split(",");
            for (String data: rawData) {
                save(data);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException(Error.MENU_WRONG_STYLE.getMessage());
        }
        
    }

    private void save(String data) {
        if (!data.matches(pattern)) {
            throw new ArrayIndexOutOfBoundsException(Error.MENU_WRONG_STYLE.getMessage());
        }
        processData(data);
    }

    private void processData(String data) {
        String[] splittedData = data.split("-");
        Menu menu = Menu.findByName(splittedData[0]);
        int quantity = Integer.parseInt(splittedData[1]);
        if (menu == null) {
            throw new NullPointerException(Error.MENU_NOT_EXIST.getMessage());
        }
        if (quantity < 1) {
            throw new IllegalArgumentException(Error.MENU_WRONG_NUMBER.getMessage());
        }
        this.orderData.saveOrder(menu, quantity);
    }
}
