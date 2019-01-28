package br.com.peixeurbano.store.service;

import java.util.Collection;
import java.util.Date;

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

	Collection<BuyOption> findAllAvailable(Date start, Date end);

	BuyOption findById(ObjectId id);

	BuyOption persist(BuyOption buyOption) throws UniqueConstraintException;

	BuyOption update(ObjectId id, BuyOption buyOption) throws UniqueConstraintException;

	BuyOption decrementQuantityCupom(ObjectId id, Long quantity);

	Collection<BuyOption> findAllWithoutRelation();

	void delete(ObjectId id);

	void validateConstraints(BuyOption buyOption) throws UniqueConstraintException;
}
