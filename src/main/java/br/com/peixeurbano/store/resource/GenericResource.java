package br.com.peixeurbano.store.resource;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;

import br.com.peixeurbano.store.exceptions.NotFoundEntityException;
import br.com.peixeurbano.store.exceptions.UniqueConstraintException;

/**
 * The Generic Resource Interface
 * 
 * @author Ryan Padilha <ryan.padilha@peixeurbano.com>
 * @since 0.1
 *
 */
public interface GenericResource<T> {

	Collection<T> list(Sort sort);

	T getById(ObjectId id) throws NotFoundEntityException;

	T persist(T entity) throws UniqueConstraintException;

	T update(ObjectId id, T entity) throws UniqueConstraintException;

	void delete(ObjectId id);
}
