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

    @Mapping(target = "author", expression = "java(getAuthor(bookDto))")
    public abstract BookEntity map(BookDto bookDto);

    @Mapping(target = "id", source = "bookEntity.id")
    @Mapping(target = "authorId", expression = "java(getAuthorId(bookEntity))")
    public abstract BookDto mapToDto(BookEntity bookEntity);

    Long getAuthorId(BookEntity entity) {
        if (entity.getAuthor() == null) {
            return -1L;
        }
        return entity.getAuthor().getId();
    }

    AuthorEntity getAuthor(BookDto bookDto) {
        if (bookDto.getAuthorId() == null) {
            return null;
        }
        Optional<AuthorEntity> authorEntityById = authorRepository.findAuthorEntityById(bookDto.getAuthorId());
        return authorEntityById.orElse(null);
    }


}
