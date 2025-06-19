package com.hungdx.bookstore.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="author_id", referencedColumnName = "id")
    private AuthorEntity author;
}
