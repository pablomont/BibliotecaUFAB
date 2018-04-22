package exception;

public class ItemExistenteException extends Exception {

	/**
	* <h1>ItemExistenteException</h1>
	* ItemExistenteException lança um exceção para mostrar que o item já existe 
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
	private static final long serialVersionUID = 1L;
	/** Quando ocorre um erro o metodo usa
	 *  @param msg para mostrar uma mensagem de que o item já existe
	 */
	public ItemExistenteException(String msg) {
		super(msg);
	}
	
	/** Quando ocorre um erro o metodo usa
	 *  @param msg para mostrar uma mensagem de que o item já existe
	 *  @param cause mostra a causa do erro
	 */
	public ItemExistenteException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
