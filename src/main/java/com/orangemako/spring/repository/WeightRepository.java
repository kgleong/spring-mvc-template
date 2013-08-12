package com.orangemako.spring.repository;

import com.orangemako.spring.domain.User;
import com.orangemako.spring.domain.Weight;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Weight repository.
 *
 * @author Kevin Leong
 */
public interface WeightRepository extends PagingAndSortingRepository<Weight, Long>, JpaSpecificationExecutor<Weight> {

    List<Weight> findByUser(User user);
}
