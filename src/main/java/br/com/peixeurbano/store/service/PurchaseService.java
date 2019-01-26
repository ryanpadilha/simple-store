package br.com.peixeurbano.store.service;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;

import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.Purchase;

/**
 * Purchase Service
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public interface PurchaseService {

	Collection<Purchase> list(Sort sort);

	Purchase findById(ObjectId id);

	Purchase persist(Purchase purchase) throws UniqueConstraintException;

	void delete(ObjectId id);

	void validateConstraints(Purchase purchase) throws UniqueConstraintException;
}
