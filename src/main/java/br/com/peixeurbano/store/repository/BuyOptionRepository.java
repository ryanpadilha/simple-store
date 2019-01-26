package br.com.peixeurbano.store.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.peixeurbano.store.model.BuyOption;

public interface BuyOptionRepository extends MongoRepository<BuyOption, ObjectId> {

}
