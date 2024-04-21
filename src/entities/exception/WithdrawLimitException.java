package entities.exception;

public class WithdrawLimitException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WithdrawLimitException (String msg) {
		super (msg);
	}
	
}
