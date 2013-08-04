package com.orangemako.spring.repository;

import com.orangemako.spring.domain.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

/**
 *
 *
 * @author Kevin Leong
 */
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {

}
