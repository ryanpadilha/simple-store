package br.com.peixeurbano.store.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.Deal;
import br.com.peixeurbano.store.repository.DealRepository;
import br.com.peixeurbano.store.service.DealService;

/**
 * Deal Service Implementation
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@Service
public class DealServiceImpl implements DealService {

	@Autowired
	private DealRepository repository;

//	@Autowired
//	private ResourceMessage message;

	@Override
	public Collection<Deal> list(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public Deal findById(ObjectId id) {
		Optional<Deal> persisted = repository.findById(id);

		if (!persisted.isPresent())
			return null;

		return persisted.get();
	}

	@Override
	public Deal persist(Deal deal) throws UniqueConstraintException {
		return repository.save(deal);
	}

	@Override
	public Deal update(ObjectId id, Deal deal) throws UniqueConstraintException {
		return repository.save(deal);
	}

	@Override
	public void delete(ObjectId id) {
		repository.deleteById(id);
	}

	@Override
	public void validateConstraints(Deal deal) throws UniqueConstraintException {

	}

	@Override
	public Deal incrementTotalSold(ObjectId id, Long quantity) {
		Deal entity = null;
		final Deal persisted = this.findById(id);
		if (null != persisted) {
			persisted.setTotalSold(persisted.getTotalSold() + quantity);
			entity = repository.save(persisted);
		}

		return entity;
	}

}
