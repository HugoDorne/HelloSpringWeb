package com.github.hugodorne.repository;

import com.github.hugodorne.model.EmpruntEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpruntRepository extends JpaRepository<EmpruntEntity, Integer> {
}
