package com.hungdx.bookstore.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hungdx.bookstore.TestDataUtil;
import com.hungdx.bookstore.dto.BookDto;
import com.hungdx.bookstore.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BookControllerIntegrationTests {
    private final ObjectMapper mapper;
    private final BookService service;
    private final MockMvc mockMvc;

    @Autowired
    public BookControllerIntegrationTests(ObjectMapper mapper, BookService service, MockMvc mockMvc) {
        this.mapper = mapper;
        this.service = service;
        this.mockMvc = mockMvc;
    }

    @Test
    public void testThatCreateBookSuccessfullyReturnsSavedBook() throws Exception {
        BookDto dto = TestDataUtil.createBookDto();
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("War and Peace IV"));
    }

    @Test
    public void testThatListBookSuccessfullyReturnListSavedBooks() throws Exception {
        BookDto dto = TestDataUtil.createBookDto();
        String json = mapper.writeValueAsString(dto);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").isNumber())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("War and Peace IV"));
    }
}
