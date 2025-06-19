package com.hungdx.bookstore.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AuthorDto {
    private Long id;
    private String name;
    private Integer age;
}
