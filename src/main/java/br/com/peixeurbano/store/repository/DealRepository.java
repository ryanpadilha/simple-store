package br.com.peixeurbano.store.repository;

import java.util.Collection;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.peixeurbano.store.model.Deal;

/**
 * Deal Repository
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public interface DealRepository extends MongoRepository<Deal, ObjectId> {

	Deal findByUrl(String url);

	Collection<Deal> findAllByPublishDateLessThanEqualAndEndDateGreaterThanEqual(Date start, Date end);
}
