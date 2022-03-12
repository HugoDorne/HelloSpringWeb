package com.github.hugodorne.repository;

import com.github.hugodorne.model.PersonneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<PersonneEntity,Integer> {
}
