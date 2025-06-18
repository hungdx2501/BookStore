package com.hungdx.bookstore.repository;

import com.hungdx.bookstore.model.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {
    public BookEntity findBookEntityById(Long id);
}
