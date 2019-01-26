package br.com.peixeurbano.store.service;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;

import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.Deal;

/**
 * Deal Service Interface
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public interface DealService {

	Collection<Deal> list(Sort sort);

	Deal findById(ObjectId id);

	Deal persist(Deal deal) throws UniqueConstraintException;

	Deal update(ObjectId id, Deal deal) throws UniqueConstraintException;

	Deal incrementTotalSold(ObjectId id, Long quantity);

	void delete(ObjectId id);

	void validateConstraints(Deal deal) throws UniqueConstraintException;
}
