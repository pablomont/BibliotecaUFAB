package biblioteca;

public class AcessoNegadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public AcessoNegadoException(String msg) {
		super(msg);
	}
	
	public AcessoNegadoException(String msg, Throwable cause) {
		super(msg,cause);
	}
	
}
