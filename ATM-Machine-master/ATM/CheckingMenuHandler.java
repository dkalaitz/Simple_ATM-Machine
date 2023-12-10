import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CheckingMenuHandler {
    private Scanner menuInput;
    private DecimalFormat moneyFormat;
    private Account account;

    public CheckingMenuHandler(Scanner menuInput, DecimalFormat moneyFormat, Account account) {
        this.menuInput = menuInput;
        this.moneyFormat = moneyFormat;
        this.account = account;
    }

    public void handleCheckingMenu() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nCheckings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("\nChoice: ");
                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nCheckings Account Balance: " + moneyFormat.format(account.getCheckingBalance()));
                        break;
                    case 2:
                        account.getCheckingWithdrawInput();
                        break;
                    case 3:
                        account.getCheckingDepositInput();
                        break;
                    case 4:
                        account.getTransferInput("Checkings");
                        break;
                    case 5:
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
