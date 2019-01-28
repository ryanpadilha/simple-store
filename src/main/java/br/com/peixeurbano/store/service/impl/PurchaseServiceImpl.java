package br.com.peixeurbano.store.service.impl;

import java.util.Collection;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.BuyOption;
import br.com.peixeurbano.store.model.Deal;
import br.com.peixeurbano.store.model.Purchase;
import br.com.peixeurbano.store.repository.PurchaseRepository;
import br.com.peixeurbano.store.service.BuyOptionService;
import br.com.peixeurbano.store.service.DealService;
import br.com.peixeurbano.store.service.PurchaseService;

/**
 * Purchase Service
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	@Autowired
	private PurchaseRepository repository;

	@Autowired
	private DealService dealService;

	@Autowired
	private BuyOptionService boptService;

	@Override
	public Collection<Purchase> list(Sort sort) {
		return repository.findAll(sort);
	}

	@Override
	public Purchase findById(ObjectId id) {
		Optional<Purchase> persisted = repository.findById(id);

		if (!persisted.isPresent())
			return null;

		return persisted.get();
	}

	@Override
	public Purchase persist(Purchase purchase) throws UniqueConstraintException {
		Purchase entity = new Purchase();

		BuyOption boptCupom = boptService.decrementQuantityCupom(purchase.getBuyOptionId(), purchase.getQuantity());
		if (null != boptCupom) {
			dealService.incrementTotalSold(purchase.getDealId(), purchase.getQuantity());

			final Deal persisted = dealService.findById(purchase.getDealId());
			persisted.removeBuyOption(boptService.findById(purchase.getBuyOptionId()));
			persisted.addBuyOption(boptService.findById(purchase.getBuyOptionId()));
			dealService.persist(persisted);

			return repository.save(purchase);
		}

		return entity;
	}

	@Override
	public void delete(ObjectId id) {
		repository.deleteById(id);
	}

	@Override
	public void validateConstraints(Purchase purchase) throws UniqueConstraintException {

	}

}
