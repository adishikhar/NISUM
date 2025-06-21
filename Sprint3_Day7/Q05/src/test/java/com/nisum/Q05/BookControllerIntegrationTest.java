package com.nisum.Q05;



import com.nisum.Q05.model.Book;
import com.nisum.Q05.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerIntegrationTest {

    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @Autowired private BookService bookService;

    @BeforeEach
    public void setup() {
        bookService.clearAll();
    }

    @Test
    public void testAddBook() throws Exception {
        Book book = new Book();
        book.setTitle("Spring");
        book.setAuthor("Aditya Shikhar");
        book.setPublishedYear(2020);

        mockMvc.perform(post("/books")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(book)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Spring")));
    }

    @Test
    public void testGetAllBooks() throws Exception {
        Book book = new Book();
        book.setTitle("Spring Boot");
        book.setAuthor("Aditya Shikhar");
        book.setPublishedYear(2021);
        bookService.addBook(book);

        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].author", is("Aditya Shikhar")));
    }

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book();
        book.setTitle("REST API Guide");
        book.setAuthor("Alex Smith");
        book.setPublishedYear(2022);
        Book saved = bookService.addBook(book);

        mockMvc.perform(get("/books/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author", is("Alex Smith")));
    }

    @Test
    public void testUpdateBook() throws Exception {
        Book book = new Book();
        book.setTitle("Old Title");
        book.setAuthor("Author A");
        book.setPublishedYear(2019);
        Book saved = bookService.addBook(book);

        saved.setTitle("New Title");

        mockMvc.perform(put("/books/" + saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(saved)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("New Title")));
    }

    @Test
    public void testDeleteBook() throws Exception {
        Book book = new Book();
        book.setTitle("To be deleted");
        book.setAuthor("Ghost");
        book.setPublishedYear(2000);
        Book saved = bookService.addBook(book);

        mockMvc.perform(delete("/books/" + saved.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/books/" + saved.getId()))
                .andExpect(status().isNotFound());
    }
}

