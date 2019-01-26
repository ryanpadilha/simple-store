package br.com.peixeurbano.store.resource.impl;

import java.util.Collection;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.peixeurbano.store.exceptions.NotFoundEntityException;
import br.com.peixeurbano.store.exceptions.UniqueConstraintException;
import br.com.peixeurbano.store.model.Purchase;
import br.com.peixeurbano.store.service.PurchaseService;

/**
 * The Purchase Resource REST API.
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@RestController
@RequestMapping(value = "/api/v1/purchases")
public class PurchaseResourceImpl {

	@Autowired
	private PurchaseService service;

	@RequestMapping(method = RequestMethod.GET)
	public Collection<Purchase> list(Sort sort) {
		return service.list(sort);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Purchase getById(@PathVariable("id") ObjectId id) throws NotFoundEntityException {
		return service.findById(id);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Purchase process(@Valid @RequestBody Purchase entity) throws UniqueConstraintException {
		return service.persist(entity);
	}
}
