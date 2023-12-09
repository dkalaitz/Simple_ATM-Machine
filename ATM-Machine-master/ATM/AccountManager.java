

import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.InputMismatchException;

public class AccountManager {
	private AccountTransferProcessor accountManagerProduct = new AccountTransferProcessor();
	private Scanner input = new Scanner(System.in);
	private DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");

	public double getCheckingBalance() {
		return accountManagerProduct.getCheckingBalance();
	}

	public void setCheckingBalance(double checkingBalance) {
		accountManagerProduct.setCheckingBalance(checkingBalance);
	}

	public double getSavingBalance() {
		return accountManagerProduct.getSavingBalance();
	}

	public void setSavingBalance(double savingBalance) {
		accountManagerProduct.setSavingBalance(savingBalance);
	}

	public void calcCheckTransfer(double amount) {
		accountManagerProduct.calcCheckTransfer(amount);
	}

	public void calcSavingTransfer(double amount) {
		accountManagerProduct.calcSavingTransfer(amount);
	}

	public void getTransferInput(String accType) {
		accountManagerProduct.getTransferInput(accType, this.input, this.moneyFormat);
	}

	public double calcCheckingWithdraw(double amount) {
		accountManagerProduct.setCheckingBalance((accountManagerProduct.getCheckingBalance() - amount));
		return accountManagerProduct.getCheckingBalance();
	}

	public void getCheckingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountManagerProduct.getCheckingBalance()));
				System.out.print("\nAmount you want to withdraw from Checkings Account: ");
				double amount = input.nextDouble();
				if ((accountManagerProduct.getCheckingBalance() - amount) >= 0 && amount >= 0) {
					calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountManagerProduct.getCheckingBalance()));
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
				System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountManagerProduct.getCheckingBalance()));
				System.out.print("\nAmount you want to deposit from Checkings Account: ");
				double amount = input.nextDouble();
				if ((accountManagerProduct.getCheckingBalance() + amount) >= 0 && amount >= 0) {
					calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + moneyFormat.format(accountManagerProduct.getCheckingBalance()));
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
		accountManagerProduct.setCheckingBalance((accountManagerProduct.getCheckingBalance() + amount));
		return accountManagerProduct.getCheckingBalance();
	}

	public double calcSavingWithdraw(double amount) {
		accountManagerProduct.setSavingBalance((accountManagerProduct.getSavingBalance() - amount));
		return accountManagerProduct.getSavingBalance();
	}

	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountManagerProduct.getSavingBalance()));
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((accountManagerProduct.getSavingBalance() - amount) >= 0 && amount >= 0) {
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountManagerProduct.getSavingBalance()));
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
				System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountManagerProduct.getSavingBalance()));
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();
				if ((accountManagerProduct.getSavingBalance() + amount) >= 0 && amount >= 0) {
					calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + moneyFormat.format(accountManagerProduct.getSavingBalance()));
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
		accountManagerProduct.setSavingBalance((accountManagerProduct.getSavingBalance() + amount));
		return accountManagerProduct.getSavingBalance();
	}
}