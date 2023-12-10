import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class AccountCreationHandler {
    private HashMap<Integer, Account> data;
    private Scanner menuInput;

    public AccountCreationHandler(HashMap<Integer, Account> data, Scanner menuInput) {
        this.data = data;
        this.menuInput = menuInput;
    }

    public void handleAccountCreation() throws IOException {
        int customerNumber = 0;
        boolean end = false;

        while (!end) {
            try {
                System.out.println("\nEnter your customer number ");
                customerNumber = menuInput.nextInt();
                Iterator it = data.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry) it.next();
                    if (!data.containsKey(customerNumber)) {
                        end = true;
                    }
                }
                if (!end) {
                    System.out.println("\nThis customer number is already registered");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }

        System.out.println("\nEnter PIN to be registered");
        int pin = menuInput.nextInt();
        data.put(customerNumber, new Account(customerNumber, pin));
        System.out.println("\nYour new account has been successfully registered!");
        System.out.println("\nRedirecting to login.............");
    }
}
