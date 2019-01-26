package br.com.peixeurbano.store.exceptions;

/**
 * Not Found Entity Exception. <br>
 * Exception Object for empty JSON response.
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class NotFoundEntityException extends Exception {

	private static final long serialVersionUID = 4635398905525453187L;

	public NotFoundEntityException() {
		super();
	}

	public NotFoundEntityException(String message) {
		super(message);
	}

	public NotFoundEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotFoundEntityException(Throwable cause) {
		super(cause);
	}
}
