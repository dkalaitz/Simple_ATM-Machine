

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class AccountTransferProcessor {
	private double checkingBalance = 0;
	private double savingBalance = 0;

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}

	public void calcCheckTransfer(double amount) {
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}

	public void calcSavingTransfer(double amount) {
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
	}

	public void getTransferInput(String accType, Scanner thisInput, DecimalFormat thisMoneyFormat) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checkings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = thisInput.nextInt();
					switch (choice) {
					case 1:
						System.out.println(
								"\nCurrent Checkings Account Balance: " + thisMoneyFormat.format(checkingBalance));
						System.out.print("\nAmount you want to deposit into your Savings Account: ");
						double amount = thisInput.nextDouble();
						if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
							calcCheckTransfer(amount);
							System.out.println(
									"\nCurrent Savings Account Balance: " + thisMoneyFormat.format(savingBalance));
							System.out.println(
									"\nCurrent Checkings Account Balance: " + thisMoneyFormat.format(checkingBalance));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				} else if (accType.equals("Savings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to: ");
					System.out.println("1. Checkings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = thisInput.nextInt();
					switch (choice) {
					case 1:
						System.out
								.println("\nCurrent Savings Account Balance: " + thisMoneyFormat.format(savingBalance));
						System.out.print("\nAmount you want to deposit into your savings account: ");
						double amount = thisInput.nextDouble();
						if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
							calcSavingTransfer(amount);
							System.out.println(
									"\nCurrent checkings account balance: " + thisMoneyFormat.format(checkingBalance));
							System.out.println(
									"\nCurrent savings account balance: " + thisMoneyFormat.format(savingBalance));
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				thisInput.next();
			}
		}
	}
}