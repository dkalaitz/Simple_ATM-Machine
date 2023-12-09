

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class AccountManager {
	private AccountTransferProcessor accountTransferProcessor = new AccountTransferProcessor();
	private Scanner input = new Scanner(System.in);
	private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public double getCheckingBalance() {
		return accountTransferProcessor.getCheckingBalance();
	}

	public void setCheckingBalance(double checkingBalance) {
		accountTransferProcessor.setCheckingBalance(checkingBalance);
	}

	public double getSavingBalance() {
		return accountTransferProcessor.getSavingBalance();
	}

	public void setSavingBalance(double savingBalance) {
		accountTransferProcessor.setSavingBalance(savingBalance);
	}

	public void calcCheckTransfer(double amount) {
		accountTransferProcessor.calcCheckTransfer(amount);
	}

	public void calcSavingTransfer(double amount) {
		accountTransferProcessor.calcSavingTransfer(amount);
	}

	public void getTransferInput(String accType) {
		accountTransferProcessor.getTransferInput(accType, this.input, this.moneyFormat);
	}

	public double calcCheckingWithdraw(double amount) {
		return accountTransferProcessor.calcCheckingWithdraw(amount);
	}

	public void getCheckingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountTransferProcessor.getCheckingBalance()));
				System.out.print("\nAmount you want to withdraw from Checkings Account: ");
				double amount = input.nextDouble();
				if ((accountTransferProcessor.getCheckingBalance() - amount) >= 0 && amount >= 0) {
					accountTransferProcessor.calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountTransferProcessor.getCheckingBalance()));
					end = true;
				} else {
					System.out.println("\nBalance Cannot be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getCheckingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountTransferProcessor.getCheckingBalance()));
				System.out.print("\nAmount you want to deposit from Checkings Account: ");
				double amount = input.nextDouble();
				if ((accountTransferProcessor.getCheckingBalance() + amount) >= 0 && amount >= 0) {
					accountTransferProcessor.calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountTransferProcessor.getCheckingBalance()));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public double calcCheckingDeposit(double amount) {
		return accountTransferProcessor.calcCheckingDeposit(amount);
	}

	public double calcSavingWithdraw(double amount) {
		return accountTransferProcessor.calcSavingWithdraw(amount);
	}

	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountTransferProcessor.getSavingBalance()));
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((accountTransferProcessor.getSavingBalance() - amount) >= 0 && amount >= 0) {
					accountTransferProcessor.calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountTransferProcessor.getSavingBalance()));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountTransferProcessor.getSavingBalance()));
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();
				if ((accountTransferProcessor.getSavingBalance() + amount) >= 0 && amount >= 0) {
					accountTransferProcessor.calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountTransferProcessor.getSavingBalance()));
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	
	public double calcSavingDeposit(double amount) {
		return accountTransferProcessor.calcSavingDeposit(amount);
	}
}