package br.com.peixeurbano.store.exceptions;

/**
 * Relationship Not Found Exception
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public class RelationshipNotFoundException extends Exception {

	private static final long serialVersionUID = -4812181805177215649L;

	public RelationshipNotFoundException() {
		super();
	}

	public RelationshipNotFoundException(String message) {
		super(message);
	}

	public RelationshipNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RelationshipNotFoundException(Throwable cause) {
		super(cause);
	}
}
