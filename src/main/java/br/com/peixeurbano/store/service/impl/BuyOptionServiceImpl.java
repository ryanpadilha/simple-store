package br.com.peixeurbano.store.service.impl;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.peixeurbano.store.config.ResourceMessage;
import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.BuyOption;
import br.com.peixeurbano.store.repository.BuyOptionRepository;
import br.com.peixeurbano.store.service.BuyOptionService;

/**
 * BuyOption Service Implementation
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @sice 0.1
 *
 */
@Service
public class BuyOptionServiceImpl implements BuyOptionService {

	@Autowired
	private BuyOptionRepository repository;

	@Autowired
	private ResourceMessage message;

	@Override
	public Collection<BuyOption> list(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public BuyOption persist(BuyOption buyOption) throws UniqueConstraintException {
		return repository.save(buyOption);
	}

	@Override
	public BuyOption update(ObjectId id, BuyOption buyOption) throws UniqueConstraintException {
		return repository.save(buyOption);
	}

	@Override
	public void delete(ObjectId id) {
		repository.deleteById(id);
	}

	@Override
	public void validateConstraints(BuyOption buyOption) throws UniqueConstraintException {

	}

}
