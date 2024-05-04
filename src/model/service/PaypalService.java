package model.service;

public class PaypalService implements OnlinePaymentService {

	@Override
	public double paymentFee(double amount) {
		return amount + (amount *0.02f);
	}

	@Override
	public double interest(double amount, int months) {
		double interest = amount+(amount*0.01f)*months;
		return paymentFee(interest);
	}

	
}
