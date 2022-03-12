package com.github.hugodorne.repository;

import com.github.hugodorne.model.LivreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivreRepository extends JpaRepository<LivreEntity,Integer> {
}
