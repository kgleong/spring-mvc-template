package com.orangemako.spring.repository;

import com.orangemako.spring.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 * User Repository.
 *
 * Extending CrudRepository gives us the following methods for free:
 *
 *   save(entity)
 *   findOne(primaryKey)
 *   findAll()
 *   count()
 *   delete(entity)
 *   exists(primaryKey)
 *
 * Another option is to extend PagingAndSortingRepository, which is a
 * subclass of CrudRepository.  It adds the following methods to make
 * paginated access to entities easier:
 *
 *   Iterable<T> findAll(sort)
 *   Page<T> findAll(pageable)
 *
 * @author Kevin Leong
 */
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {

}
