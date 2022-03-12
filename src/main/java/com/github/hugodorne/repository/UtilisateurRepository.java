package com.github.hugodorne.repository;

import com.github.hugodorne.model.UtilisateursEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateursEntity,Integer> {
}
