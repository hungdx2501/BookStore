package com.hungdx.bookstore.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String name;
    public Long authorId;
}
