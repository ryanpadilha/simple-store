package br.com.peixeurbano.store.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.peixeurbano.store.model.Purchase;

/**
 * Purchase Repository
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public interface PurchaseRepository extends MongoRepository<Purchase, ObjectId> {

}
