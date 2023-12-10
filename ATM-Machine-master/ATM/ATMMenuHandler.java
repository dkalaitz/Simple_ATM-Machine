import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMMenuHandler {
    private Scanner menuInput;
    private DecimalFormat moneyFormat;
    private Account account;
    private HashMap<Integer, Account> data;

    public ATMMenuHandler(Scanner menuInput, DecimalFormat moneyFormat, Account account, HashMap<Integer, Account> data) {
        this.menuInput = menuInput;
        this.moneyFormat = moneyFormat;
        this.account = account;
        this.data = data;
    }

    public void handleMenu() throws IOException {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\n Type 1 - Checkings Account");
                System.out.println(" Type 2 - Savings Account");
                System.out.println(" Type 3 - Exit");
                System.out.print("\nChoice: ");
                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        CheckingMenuHandler checkingMenuHandler = new CheckingMenuHandler(menuInput, moneyFormat, account);
                        checkingMenuHandler.handleCheckingMenu();
                        break;
                    case 2:
                        SavingMenuHandler savingMenuHandler = new SavingMenuHandler(menuInput, moneyFormat, account);
                        savingMenuHandler.handleSavingMenu();
                        break;
                    case 3:
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
    }
}
