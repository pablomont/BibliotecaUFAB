package exception;

public class ItemInexistenteException extends Exception {

	/**
	* <h1>ItemInexistenteException</h1>
	* ItemInexistenteException lan�a um exce��o para mostrar que o item n�o existe
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
	private static final long serialVersionUID = 1L;
	/** Quando ocorre um erro o metodo usa
	 *  @exception para definir o erro de que o item n�o existe 
	 *  @param msg para mostrar uma mensagem de que o item n�o existe
	 */
	public ItemInexistenteException(String msg) {
		super(msg);
	}
	
	/** Quando ocorre um erro o metodo usa
	 *  @exception para definir o erro de que o item n�o existe
	 *  @param msg para definir uma mensagem de erro
	 *  @param cause mostra a causa do erro
	 */
	public ItemInexistenteException(String msg, Throwable cause) {
		super(msg,cause);
	}

}
