package com.hungdx.bookstore.controller;

import com.hungdx.bookstore.dto.BookDto;
import com.hungdx.bookstore.model.BookEntity;
import com.hungdx.bookstore.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {
    private final BookService bookService;


    @GetMapping(params = "id")
    public ResponseEntity<BookDto> findBookById(@RequestParam long id) {
        BookDto entity = bookService.findBookById(id);
        return ResponseEntity.ok(entity);
    }

    @PostMapping
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto body) {
        BookDto dto = bookService.save(body);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAllBooks() {
        List<BookDto> list = bookService.findAllBooks();
        return ResponseEntity.ok(list);
    }
}
