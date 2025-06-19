package com.hungdx.bookstore.service;

import com.hungdx.bookstore.dto.BookDto;
import com.hungdx.bookstore.mapper.BookMapper;
import com.hungdx.bookstore.model.BookEntity;
import com.hungdx.bookstore.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    @Transactional
    public BookDto save(BookDto bookDto) {
        BookEntity entity = bookMapper.map(bookDto);
        return bookMapper.mapToDto(bookRepository.save(entity));
    }

    public BookDto findBookById(long id) {
        BookEntity entity = bookRepository.findBookEntityById(id);
        return bookMapper.mapToDto(entity);
    }

    public List<BookDto> findAllBooks() {
        List<BookEntity> list = bookRepository.findAll();
        return list.stream().map(bookMapper::mapToDto).toList();
    }
}
