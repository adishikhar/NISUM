package com.example.demo.controller;

import com.example.demo.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    @GetMapping
    public List<Book> getAllBooks(
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer publishedYear,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        List<Book> filtered = books.stream()
                .filter(b -> author == null || b.getAuthor().equalsIgnoreCase(author))
                .filter(b -> publishedYear == null || b.getPublishedYear() == publishedYear)
                .collect(Collectors.toList());

        int start = page * size;
        int end = Math.min(start + size, filtered.size());
        if (start >= filtered.size()) {
            return new ArrayList<>();
        }

        return filtered.subList(start, end);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                return b;
            }
        }
        throw new RuntimeException("Book not found");
    }

    @PostMapping
    public String createBook(@RequestBody Book book) {
        if (book.getTitle() == null || book.getTitle().trim().isEmpty()) {
            throw new RuntimeException("Title is required");
        }
        if (book.getAuthor() == null || book.getAuthor().trim().isEmpty()) {
            throw new RuntimeException("Author is required");
        }
        if (book.getPublishedYear() <= 0) {
            throw new RuntimeException("Published year must be greater than 0");
        }

        book.setId(idCounter.incrementAndGet());
        books.add(book);
        return "Product created!";
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book newBook) {
        for (Book b : books) {
            if (b.getId().equals(id)) {
                if (newBook.getTitle() == null || newBook.getTitle().trim().isEmpty()) {
                    throw new RuntimeException("Title is required");
                }
                if (newBook.getAuthor() == null || newBook.getAuthor().trim().isEmpty()) {
                    throw new RuntimeException("Author is required");
                }
                if (newBook.getPublishedYear() <= 0) {
                    throw new RuntimeException("Published year must be greater than 0");
                }

                b.setTitle(newBook.getTitle());
                b.setAuthor(newBook.getAuthor());
                b.setPublishedYear(newBook.getPublishedYear());
                return b;
            }
        }
        throw new RuntimeException("Book not found");
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        books.removeIf(b -> b.getId().equals(id));
        return "Book deleted!";
    }
}
