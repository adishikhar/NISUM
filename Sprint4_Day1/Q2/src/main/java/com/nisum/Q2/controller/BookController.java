package com.nisum.Q2.controller;



import com.nisum.Q2.dto.BookDTO;
import com.nisum.Q2.model.Book;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final Map<Long, Book> store = new ConcurrentHashMap<>();
    private final AtomicLong idGen = new AtomicLong();

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid BookDTO dto) {
        Long id = idGen.incrementAndGet();
        Book book = new Book(id, dto.getTitle(), dto.getAuthor(), dto.getPrice());
        store.put(id, book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @GetMapping
    public List<Book> list() {
        return new ArrayList<>(store.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable Long id) {
        Book book = store.get(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable Long id, @RequestBody @Valid BookDTO dto) {
        if (!store.containsKey(id)) return ResponseEntity.notFound().build();
        Book book = new Book(id, dto.getTitle(), dto.getAuthor(), dto.getPrice());
        store.put(id, book);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        store.remove(id);
        return ResponseEntity.noContent().build();
    }
}


