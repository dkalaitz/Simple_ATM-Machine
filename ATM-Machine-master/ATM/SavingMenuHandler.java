import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SavingMenuHandler {
    private Scanner menuInput;
    private DecimalFormat moneyFormat;
    private Account account;

    public SavingMenuHandler(Scanner menuInput, DecimalFormat moneyFormat, Account account) {
        this.menuInput = menuInput;
        this.moneyFormat = moneyFormat;
        this.account = account;
    }

    public void handleSavingMenu() {
        boolean end = false;
        while (!end) {
            try {
                System.out.println("\nSavings Account: ");
                System.out.println(" Type 1 - View Balance");
                System.out.println(" Type 2 - Withdraw Funds");
                System.out.println(" Type 3 - Deposit Funds");
                System.out.println(" Type 4 - Transfer Funds");
                System.out.println(" Type 5 - Exit");
                System.out.print("\nChoice: ");
                int selection = menuInput.nextInt();

                switch (selection) {
                    case 1:
                        System.out.println("\nSavings Account Balance: " + moneyFormat.format(account.getSavingBalance()));
                        break;
                    case 2:
                        account.getsavingWithdrawInput();
                        break;
                    case 3:
                        account.getSavingDepositInput();
                        break;
                    case 4:
                        account.getTransferInput("Savings");
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
