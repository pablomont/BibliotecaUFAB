package exception;

public class AcessoNegadoException extends Exception {

	/**
	* <h1>AcessoNegadoException</h1>
	* AcessoNegadoException lança um exceção para mostrar que
	* o acesso foi negado no sistema retornando uma mensagem predefinida.
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
	private static final long serialVersionUID = 1L;
	
	/** Quando ocorre um erro o metodo usa
	 *  @param msg de erro
	 */
	public AcessoNegadoException(String msg) {

		super(msg);
	}
	
	/** Quando ocorre um erro o metodo usa

	 *  @param msg de que o acesso foi negado ao sistema
	 *  @param cause mostra a causa do acesso foi negado ao sistema
	 */
	public AcessoNegadoException(String msg, Throwable cause) {

		super(msg,cause);
	}
	
}
