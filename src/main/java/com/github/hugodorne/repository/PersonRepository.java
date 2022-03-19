package com.github.hugodorne.repository;

import com.github.hugodorne.model.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {
}
