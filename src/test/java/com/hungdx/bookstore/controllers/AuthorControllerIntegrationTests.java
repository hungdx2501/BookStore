package com.hungdx.bookstore.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hungdx.bookstore.TestDataUtil;
import com.hungdx.bookstore.dto.AuthorDto;
import com.hungdx.bookstore.mapper.AuthorMapper;
import com.hungdx.bookstore.service.AuthorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AuthorControllerIntegrationTests {
    private final AuthorService authorService;
    private final MockMvc mockMvc;
    private final ObjectMapper mapper;

    @Autowired
    public AuthorControllerIntegrationTests(AuthorService authorService, MockMvc mockMvc, ObjectMapper mapper) {
        this.authorService = authorService;
        this.mockMvc = mockMvc;
        this.mapper = mapper;
    }

    @Test
    public void testThatCreateAuthorSuccessfullyReturnsSavedAuthor() throws Exception {
        AuthorDto dto = TestDataUtil.createAuthorDto();
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/authors")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                )
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("James Gun I"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(70));
    }

    @Test
    public void testThatListAuthorReturnHttpStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/authors")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().is(200));
    }

    @Test
    public void testThatListAuthorSuccessfullyReturnListSavedAuthors() throws Exception {
        AuthorDto dto = TestDataUtil.createAuthorDto();
        String json = mapper.writeValueAsString(dto);
        mockMvc.perform(MockMvcRequestBuilders.post("/authors")
                .contentType(MediaType.APPLICATION_JSON).content(json));

        mockMvc.perform(MockMvcRequestBuilders.get("/authors").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("James Gun I"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].age").value(70));
    }
}
