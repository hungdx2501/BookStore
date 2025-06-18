package com.hungdx.bookstore.repository;

import com.hungdx.bookstore.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    public Optional<AuthorEntity> findAuthorEntityById(Long id);
}
