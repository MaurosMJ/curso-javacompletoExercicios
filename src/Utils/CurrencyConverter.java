package Utils;

public class CurrencyConverter {

	private static final int IOF = 6;
	
	public static double dolBRL (double dolPrice, double dolQtd) {
		return dolQtd * (dolPrice + (dolPrice * (getIof() / 100f)));
	}
	
	public static int getIof() {
		return IOF;
	}
	
}
