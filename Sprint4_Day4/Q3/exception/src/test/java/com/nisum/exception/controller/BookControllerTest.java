package com.nisum.exception.controller;



import com.nisum.exception.exception.BookNotFoundException;
import com.nisum.exception.model.Book;
import com.nisum.exception.service.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationExtension;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@WebMvcTest(controllers = BookController.class)
@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    void shouldReturnBookWhenExists() throws Exception {
        Book book = new Book(1L, "Clean Code");
        when(bookService.getBookById(1L)).thenReturn(book);

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.title").value("Clean Code"))
                .andDo(document("get-book-success"));
    }

    @Test
    void shouldReturn404WhenBookNotFound() throws Exception {
        when(bookService.getBookById(100L))
                .thenThrow(new BookNotFoundException(100L));

        mockMvc.perform(get("/api/books/100"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Book with ID 100 not found."))
                .andDo(document("get-book-not-found"));
    }
}

