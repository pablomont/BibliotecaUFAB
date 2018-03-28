package exception;

public class ItemInexistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ItemInexistenteException(String msg) {
		super(msg);
	}
	
	public ItemInexistenteException(String msg, Throwable cause) {
		super(msg,cause);
	}

}
