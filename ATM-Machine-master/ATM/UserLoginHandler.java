import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UserLoginHandler {
    private HashMap<Integer, Account> data;
    private Scanner menuInput;
    private DecimalFormat moneyFormat;
    private Account account;

    public UserLoginHandler(HashMap<Integer, Account> data, Scanner menuInput, DecimalFormat moneyFormat) {
        this.data = data;
        this.menuInput = menuInput;
        this.moneyFormat = moneyFormat;
    }

    public void handleLogin() {
        boolean end = false;
        int customerNumber = 0;
        int pinNumber = 0;

        while (!end) {
            try {
                customerNumber = getCustomerNumberInput();
                pinNumber = getPinNumberInput();

                account = findAccount(customerNumber, pinNumber);
                if (account != null) {
                    System.out.println("\nLogin Successful!");
                    end = true;
                } else {
                    System.out.println("\nWrong Customer Number or Pin Number");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Character(s). Only Numbers.");
            }
        }
    }

    private int getCustomerNumberInput() {
        System.out.print("\nEnter your customer number: ");
        return menuInput.nextInt();
    }

    private int getPinNumberInput() {
        System.out.print("\nEnter your PIN number: ");
        return menuInput.nextInt();
    }

    private Account findAccount(int customerNumber, int pinNumber) {
        Iterator it = data.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            Account acc = (Account) pair.getValue();

            if (data.containsKey(customerNumber) && pinNumber == acc.getPinNumber()) {
                return acc;
            }
        }
        return null;
    }

    public Account getAccount() {
        return account;
    }
}
