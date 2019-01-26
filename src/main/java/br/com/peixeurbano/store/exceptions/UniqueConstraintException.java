package br.com.peixeurbano.store.exceptions;

/**
 * Unique Constraint Exception
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class UniqueConstraintException extends Exception {

	private static final long serialVersionUID = -6834558953092288336L;

	public UniqueConstraintException() {
		super();
	}

	public UniqueConstraintException(String message) {
		super(message);
	}

	public UniqueConstraintException(String message, Throwable cause) {
		super(message, cause);
	}

	public UniqueConstraintException(Throwable cause) {
		super(cause);
	}
}
