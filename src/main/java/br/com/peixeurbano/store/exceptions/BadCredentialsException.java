package br.com.peixeurbano.store.exceptions;

/**
 * Bad Credentials Exception
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class BadCredentialsException extends Exception {

	private static final long serialVersionUID = 1291309822534793337L;

	public BadCredentialsException() {
		super();
	}

	public BadCredentialsException(String message) {
		super(message);
	}

	public BadCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}

	public BadCredentialsException(Throwable cause) {
		super(cause);
	}
}
