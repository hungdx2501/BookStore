package com.hungdx.bookstore.service;

import com.hungdx.bookstore.dto.BookDto;
import com.hungdx.bookstore.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    public void save(BookDto bookDto) {

    }
}
