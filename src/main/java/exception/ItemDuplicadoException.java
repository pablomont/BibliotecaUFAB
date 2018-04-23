package exception;

public class ItemDuplicadoException extends Exception {

	/**
	* <h1>ItemExistenteException</h1>
	* ItemExistenteException lan�a um exce��o para mostrar que o item j� existe 
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
	private static final long serialVersionUID = 1L;
	/** Quando ocorre um erro o metodo usa
	 *  @param msg mostra uma mensagem de que o item j� existe
	 */
	public ItemDuplicadoException(String msg) {
		super(msg);
	}
	
	/** Quando ocorre um erro o metodo usa
	 *  @param msg mostra uma mensagem de que o item j� existe
	 *  @param cause mostra a causa do erro
	 */
	public ItemDuplicadoException(String msg, Throwable cause) {
		super(msg,cause);
	}
}
