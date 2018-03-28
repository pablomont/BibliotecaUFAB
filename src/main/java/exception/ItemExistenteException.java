package exception;

public class ItemExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemExistenteException(String msg) {
		super(msg);
	}
	
	public ItemExistenteException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
