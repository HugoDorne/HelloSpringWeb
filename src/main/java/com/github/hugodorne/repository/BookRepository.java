package com.github.hugodorne.repository;

import com.github.hugodorne.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Book repository.
 */
@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {
}
