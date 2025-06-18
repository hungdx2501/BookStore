package com.hungdx.bookstore.mapper;


import com.hungdx.bookstore.dto.AuthorDto;
import com.hungdx.bookstore.model.AuthorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class AuthorMapper {
    public abstract AuthorEntity map(AuthorDto dto);

    public abstract AuthorDto mapToDto(AuthorEntity entity);
}
