package br.com.peixeurbano.store.service;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;

import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.BuyOption;

/**
 * BuyOption Service Interface
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public interface BuyOptionService {

	Collection<BuyOption> list(Sort sort);

	BuyOption persist(BuyOption buyOption) throws UniqueConstraintException;

	BuyOption update(ObjectId id, BuyOption buyOption) throws UniqueConstraintException;

	void delete(ObjectId id);

	void validateConstraints(BuyOption buyOption) throws UniqueConstraintException;
}