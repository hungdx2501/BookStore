package com.hungdx.bookstore.service;

import com.hungdx.bookstore.dto.AuthorDto;
import com.hungdx.bookstore.mapper.AuthorMapper;
import com.hungdx.bookstore.model.AuthorEntity;
import com.hungdx.bookstore.repository.AuthorRepository;
import com.hungdx.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository repository;
    private final AuthorMapper mapper;
    public List<AuthorDto> getAllAuthors() {
        return repository.findAll().stream().map(mapper::mapToDto).toList();
    }

    public AuthorDto findAuthorById(Long id) {
        return mapper.mapToDto(repository.findAuthorEntityById(id).orElse(null));
    }

    public AuthorDto addAuthor(AuthorDto authorDto) {
        return mapper.mapToDto(repository.save(mapper.map(authorDto)));
    }
}
