import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
	private AccountManager accountManager = new AccountManager();
	// variables
	private int customerNumber;
	private int pinNumber;
	// non-constructor
	public Account() {
	}
	
	//parameter-constructor
	public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}

	public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		accountManager.setCheckingBalance(checkingBalance);
		accountManager.setSavingBalance(savingBalance);
	}
	
	//getter & setter
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		return accountManager.getCheckingBalance();
	}

	public double getSavingBalance() {
		return accountManager.getSavingBalance();
	}

	public double calcCheckingWithdraw(double amount) {
		return accountManager.calcCheckingWithdraw(amount);
	}

	public double calcSavingWithdraw(double amount) {
		return accountManager.calcSavingWithdraw(amount);
	}

	public double calcCheckingDeposit(double amount) {
		return accountManager.calcCheckingDeposit(amount);
	}

	public double calcSavingDeposit(double amount) {
		return accountManager.calcSavingDeposit(amount);
	}

	public void calcCheckTransfer(double amount) {
		accountManager.calcCheckTransfer(amount);
	}

	public void calcSavingTransfer(double amount) {
		accountManager.calcSavingTransfer(amount);
	}

	public void getCheckingWithdrawInput() {
		accountManager.getCheckingWithdrawInput();
	}

	public void getsavingWithdrawInput() {
		accountManager.getsavingWithdrawInput();
	}

	public void getCheckingDepositInput() {
		accountManager.getCheckingDepositInput();
	}

	public void getSavingDepositInput() {
		accountManager.getSavingDepositInput();
	}

	public void getTransferInput(String accType) {
		accountManager.getTransferInput(accType);
	}
}

