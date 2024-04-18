package entities;

public class Account {

	private int accountNum;
	private String accountHolder;
	private double accountBalance;
	private final int tax = 5;

	public Account(int accountNum, String accountHolder, double accountBalance) {
		this.setAccountBalance(accountBalance);
		this.setAccountHolder(accountHolder);
		this.setAccountNum(accountNum);
	}

	public Account(int accountNum, String accountHolder) {
		this.setAccountBalance(0);
		this.setAccountHolder(accountHolder);
		this.setAccountNum(accountNum);
	}

	private int getAccountNum() {
		return accountNum;
	}

	private void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	private String getAccountHolder() {
		return accountHolder;
	}

	private void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	private double getAccountBalance() {
		return accountBalance;
	}

	private void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	private int getTax() {
		return tax;
	}

	public void addBalance(double value) {
		this.setAccountBalance(this.getAccountBalance() + value);
	}

	public void withdraw(double value) {
		this.setAccountBalance(this.getAccountBalance() - value - this.getTax());
	}

	public String toString() {

		return "Account " + this.getAccountNum() + ", Holder: " + this.getAccountHolder() + ", Balance: $ "
				+ String.format("%.2f", this.getAccountBalance());
	}

}
