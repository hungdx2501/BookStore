package com.hungdx.bookstore;

import com.hungdx.bookstore.dto.BookDto;
import com.hungdx.bookstore.model.AuthorEntity;
import com.hungdx.bookstore.model.BookEntity;

public final class TestDataUtil {

    public static BookEntity createTestBookEntityA() {
        return BookEntity.builder()
                .id(1L)
                .name("Peace and War I")
                .build();
    }

    public static BookEntity createTestBookEntityB() {
        return BookEntity.builder()
                .id(2L)
                .name("Peace and War II")
                .build();
    }

    public static BookEntity createTestBookEntityC() {
        return BookEntity.builder()
                .id(3L)
                .name("Peace and War III")
                .build();
    }

    public static AuthorEntity createAuthorEntityA() {
        return AuthorEntity.builder()
                .id(1L)
                .name("James Gun I")
                .age(85)
                .build();
    }

    public static AuthorEntity createAuthorEntityB() {
        return AuthorEntity.builder()
                .id(2L)
                .name("James Gun II")
                .age(30)
                .build();
    }

    public static AuthorEntity createAuthorEntityC() {
        return AuthorEntity.builder()
                .id(3L)
                .name("James Gun III")
                .age(100)
                .build();
    }

    public static BookDto createBookDto() {
        return BookDto.builder()
                .id(1L)
                .name("War and Peace IV")
                .authorId(2L)
                .build();
    }
}
