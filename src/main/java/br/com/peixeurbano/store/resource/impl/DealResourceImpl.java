package br.com.peixeurbano.store.resource.impl;

import java.util.Collection;
import java.util.Date;

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
import br.com.peixeurbano.store.model.Deal;
import br.com.peixeurbano.store.resource.GenericResource;
import br.com.peixeurbano.store.service.DealService;

/**
 * The Deal Resource REST API.
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
@RestController
@RequestMapping(value = "/api/v1/deals")
public class DealResourceImpl implements GenericResource<Deal> {

	@Autowired
	private DealService service;

	@Override
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Deal> list(Sort sort) {
		return service.list(sort);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Deal getById(@PathVariable("id") ObjectId id) throws NotFoundEntityException {
		return service.findById(id);
	}

	@Override
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Deal persist(@Valid @RequestBody Deal entity) throws UniqueConstraintException {
		return service.persist(entity);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseStatus(code = HttpStatus.OK)
	public Deal update(@PathVariable("id") ObjectId id, @Valid @RequestBody Deal entity)
			throws UniqueConstraintException {
		return service.update(id, entity);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") ObjectId id) {
		service.delete(id);
	}

	@RequestMapping(value = "/slug/{url}", method = RequestMethod.GET)
	public Deal getByUrl(@PathVariable("url") String url) throws NotFoundEntityException {
		return service.findByUrl(url);
	}

	@RequestMapping(value = "/all-available", method = RequestMethod.GET)
	public Collection<Deal> listAllAvailable() {
		final Date currentDate = new Date();
		return service.findAllAvailable(currentDate, currentDate);
	}

}
