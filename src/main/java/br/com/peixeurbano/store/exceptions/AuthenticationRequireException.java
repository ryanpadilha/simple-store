package br.com.peixeurbano.store.exceptions;

/**
 * Authentication Require Exception
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class AuthenticationRequireException extends Exception {

	private static final long serialVersionUID = 5043909880550922599L;

	public AuthenticationRequireException() {
		super();
	}

	public AuthenticationRequireException(String message) {
		super(message);
	}

	public AuthenticationRequireException(String message, Throwable cause) {
		super(message, cause);
	}

	public AuthenticationRequireException(Throwable cause) {
		super(cause);
	}
}
