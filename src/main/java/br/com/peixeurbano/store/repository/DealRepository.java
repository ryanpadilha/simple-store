package br.com.peixeurbano.store.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.peixeurbano.store.model.Deal;

public interface DealRepository extends MongoRepository<Deal, ObjectId> {

}
