package com.hungdx.bookstore.mapper;

import com.hungdx.bookstore.dto.BookDto;
import com.hungdx.bookstore.model.AuthorEntity;
import com.hungdx.bookstore.model.BookEntity;
import com.hungdx.bookstore.repository.AuthorRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = "spring")
public abstract class BookMapper {

    @Autowired
    private AuthorRepository authorRepository;

    @Mapping(target = "id", expression = "java(bookDto.getId())")
    @Mapping(target = "name", expression = "java(bookDto.getName())")
    @Mapping(target = "author", expression = "java(getAuthor(bookDto))")
    public abstract BookEntity map(BookDto bookDto);
    @Mapping(target = "id", expression = "java(bookEntity.getId())")
    @Mapping(target = "name", expression = "java(bookEntity.getName())")
    public abstract BookDto mapToDto(BookEntity bookEntity);

    AuthorEntity getAuthor(BookDto bookDto) {
        if (bookDto.getAuthorId() == null) {
            return null;
        }
        Optional<AuthorEntity> authorEntityById = authorRepository.findAuthorEntityById(bookDto.getAuthorId());
        return authorEntityById.orElse(null);
    }


}
