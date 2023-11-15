package christmas.io;

import java.util.Map;
import java.util.NoSuchElementException;

import christmas.constant.Constants;
import christmas.constant.Error;
import christmas.constant.Menu;
import christmas.constant.Message;
import christmas.order.Order;

import camp.nextstep.edu.missionutils.Console;

public class OrderInput {
    Order orderData;

    public boolean order() {
        System.out.println(Message.ORDER.getMessage());
        return input();
    }

    private boolean input() {
        while (true) {
            try {
                orderData = new Order();
                getInput();
                orderData.calculate();
                return true;
            } catch (NoSuchElementException e) {
                return false;
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
            for (String data : rawData) {
                save(data);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException(Error.MENU_WRONG_STYLE.getMessage());
        }
    }

    private void save(String data) {
        if (!data.matches(Constants.MENUSETPATTERN)) {
            throw new ArrayIndexOutOfBoundsException(Error.MENU_WRONG_STYLE.getMessage());
        }
        processData(data);
        canOrder();
    }

    private void processData(String data) {
        String[] splittedData = data.split("-");
        Menu menu = Menu.findByName(splittedData[0]);
        int quantity = Integer.parseInt(splittedData[1]);
        if (quantity < 1) {
            throw new IllegalArgumentException(Error.MENU_WRONG_NUMBER.getMessage());
        }
        this.orderData.saveOrder(menu, quantity);
    }

    private void canOrder() {
        int total = 0;
        boolean flag = false;
        for (Map.Entry<Menu, Integer> entry : orderData.getOrder().entrySet()) {
            total += entry.getValue();
            if (!flag && !entry.getKey().getType().equals(Constants.MENUCRITERIA))
                flag = true;
        }
        if (total > Constants.QUANTITYLIMIT) {
            throw new IllegalArgumentException(Error.MENU_TOO_MANY.getMessage());
        }
        if (!flag) {
            throw new IllegalArgumentException(Error.MENU_ONLY_DRINK.getMessage());
        }
    }

    public Order getOrder() {
        return this.orderData;
    }
}
