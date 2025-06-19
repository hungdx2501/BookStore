package com.hungdx.bookstore.controller;

import com.hungdx.bookstore.dto.AuthorDto;
import com.hungdx.bookstore.service.AuthorService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @PostMapping
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto body) {
        return ResponseEntity.ok(authorService.addAuthor(body));
    }

    @GetMapping(params = "id")
    public ResponseEntity<AuthorDto> findAuthorById(@RequestParam Long id) {
        return ResponseEntity.ok(authorService.findAuthorById(id));
    }
}
