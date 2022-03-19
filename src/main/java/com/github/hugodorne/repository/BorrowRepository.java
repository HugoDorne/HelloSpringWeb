package com.github.hugodorne.repository;

import com.github.hugodorne.model.BorrowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Borrow repository.
 */
@Repository
public interface BorrowRepository extends JpaRepository<BorrowEntity, Integer> {
}
