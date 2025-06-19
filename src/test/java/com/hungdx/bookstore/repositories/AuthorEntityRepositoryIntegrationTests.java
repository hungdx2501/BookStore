package com.hungdx.bookstore.repositories;

import com.hungdx.bookstore.TestDataUtil;
import com.hungdx.bookstore.model.AuthorEntity;
import com.hungdx.bookstore.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class AuthorEntityRepositoryIntegrationTests {
    private final AuthorRepository underTest;

    @Autowired
    public AuthorEntityRepositoryIntegrationTests(AuthorRepository underTest) {
        this.underTest = underTest;
    }

    @Test
    public void testThatAuthorCanBeCreatedAndRecalled() {
        AuthorEntity entity = TestDataUtil.createAuthorEntityA();
        underTest.save(entity);
        Optional<AuthorEntity> result = underTest.findAuthorEntityById(entity.getId());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(entity);
    }

    @Test
    public void testThatMultipleAuthorsCanBeCreatedAndRecalled() {
        underTest.save(TestDataUtil.createAuthorEntityA());
        underTest.save(TestDataUtil.createAuthorEntityB());
        underTest.save(TestDataUtil.createAuthorEntityC());
        List<AuthorEntity> result = underTest.findAll();
        assertThat(result.size()).isEqualTo(3);
    }

    @Test
    public void testThatAuthorWithAgeLessThan() {
        AuthorEntity entityA = TestDataUtil.createAuthorEntityA();
        AuthorEntity entityB = TestDataUtil.createAuthorEntityB();
        AuthorEntity entityC = TestDataUtil.createAuthorEntityC();
        underTest.save(entityA);
        underTest.save(entityB);
        underTest.save(entityC);
        List<AuthorEntity> result = underTest.findAuthorEntityByAgeLessThan(50);
        assertThat(result).containsExactly(entityB);
    }

    @Test
    public void testThatAuthorWithAgeGreaterThan() {
        AuthorEntity entityA = TestDataUtil.createAuthorEntityA();
        AuthorEntity entityB = TestDataUtil.createAuthorEntityB();
        AuthorEntity entityC = TestDataUtil.createAuthorEntityC();
        underTest.save(entityA);
        underTest.save(entityB);
        underTest.save(entityC);
        List<AuthorEntity> result = underTest.findAuthorEntityByAgeGreaterThan(50);
        assertThat(result).containsExactly(entityA, entityC);
    }

}
