package christmas.userinput;

public class Input {
    private Date dateInput = new Date();

    public void run() {
        System.out.println(Message.INIT.getMessage());
        int date = dateInput.getDate();
    }
}
