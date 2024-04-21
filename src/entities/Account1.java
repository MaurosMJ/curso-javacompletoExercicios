package entities;

import entities.exception.NotBalanceException;
import entities.exception.WithdrawLimitException;

public class Account1 {

	private int number;
	private String holder;
	private double balance;
	private double withdrawLimit;

	public Account1(int number, String holder, double balance, double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public void deposit(double amount) {

		this.balance += amount;
	}

	public void withdraw(double amount) throws WithdrawLimitException, NotBalanceException {

		if (amount > withdrawLimit) {
			throw new WithdrawLimitException("Withdraw error: The amount exceeds withdraw limit");
		}
		
		if (amount > balance) {
			throw new NotBalanceException("Withdraw error: Not enough balance");
		}

		this.balance -= amount;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public double getBalance() {
		return balance;
	}

	public double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public String toString() {
		return "New balance: " + String.format("%.2f", this.getBalance());
	}

}
