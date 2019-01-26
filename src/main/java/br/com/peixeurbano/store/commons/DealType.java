package br.com.peixeurbano.store.commons;

/**
 * Deal Type
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public enum DealType {

	LOCAL("local"), PRODUCT("product"), TRAVEL("travel");

	private String text;

	private DealType(String value) {
		this.text = value;
	}

	public String getText() {
		return text;
	}

}
