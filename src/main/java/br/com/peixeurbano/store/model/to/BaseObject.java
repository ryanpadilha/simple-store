package br.com.peixeurbano.store.model.to;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * The Base Object API
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@JsonSerialize
public class BaseObject implements Serializable {

	private static final long serialVersionUID = 2189293205118584628L;

}
