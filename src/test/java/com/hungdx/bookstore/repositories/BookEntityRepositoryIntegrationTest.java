package com.hungdx.bookstore.repositories;


import com.hungdx.bookstore.TestDataUtil;
import com.hungdx.bookstore.model.BookEntity;
import com.hungdx.bookstore.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookEntityRepositoryIntegrationTest {
    private final BookRepository underTest;

    @Autowired
    public BookEntityRepositoryIntegrationTest(BookRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        BookEntity entity = TestDataUtil.createTestBookEntityA();
        BookEntity entityB = underTest.save(entity);
        assertThat(entityB).isEqualTo(entity);
    }

    @Test
    public void testThatMultipleBooksCanBeCreatedAndRecalled() {
        BookEntity entityA = TestDataUtil.createTestBookEntityA();
        BookEntity entityB = TestDataUtil.createTestBookEntityB();
        BookEntity entityC = TestDataUtil.createTestBookEntityC();
        underTest.save(entityA);
        underTest.save(entityB);
        underTest.save(entityC);
        List<BookEntity> books = underTest.findAll();
        assertThat(books.size()).isEqualTo(3);
        assertThat(books).containsExactly(entityA, entityB, entityC);
    }
}
