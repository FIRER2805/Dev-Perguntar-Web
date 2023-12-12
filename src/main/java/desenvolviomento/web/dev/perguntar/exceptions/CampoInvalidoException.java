package desenvolviomento.web.dev.perguntar.exceptions;

public class CampoInvalidoException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8235468656356776564L;
	
	public CampoInvalidoException(String mensagem, Exception e) {
		super(mensagem, e);
	}
	
	public CampoInvalidoException(String mensagem) {
		super(mensagem);
	}
}
