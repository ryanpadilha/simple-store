package br.com.peixeurbano.store.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.peixeurbano.store.model.BuyOption;

/**
 * BuyOption Repository
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public interface BuyOptionRepository extends MongoRepository<BuyOption, ObjectId> {

}
