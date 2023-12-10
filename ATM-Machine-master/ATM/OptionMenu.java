import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class OptionMenu {
    private Scanner menuInput = new Scanner(System.in);
    private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    private HashMap<Integer, Account> data = new HashMap<>();

    public void mainMenu() throws IOException {
        data.put(952141, new Account(952141, 191904, 1000, 5000));
        data.put(123, new Account(123, 123, 20000, 50000));

        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n Type 1 - Login");
                System.out.println(" Type 2 - Create Account");
                System.out.print("\nChoice: ");
                int choice = menuInput.nextInt();

                switch (choice) {
                    case 1:
                        UserLoginHandler loginHandler = new UserLoginHandler(data, menuInput, moneyFormat);
                        loginHandler.handleLogin();
                        ATMMenuHandler atmMenuHandler = new ATMMenuHandler(menuInput, moneyFormat, loginHandler.getAccount(), data);
                        atmMenuHandler.handleMenu();
                        end = true;
                        break;
                    case 2:
                        AccountCreationHandler creationHandler = new AccountCreationHandler(data, menuInput);
                        creationHandler.handleAccountCreation();
                        end = true;
                        break;
                    default:
                        System.out.println("\nInvalid Choice.");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Choice.");
                menuInput.next();
            }
        }
        System.out.println("\nThank You for using this ATM.\n");
        menuInput.close();
        System.exit(0);
    }
    
}
