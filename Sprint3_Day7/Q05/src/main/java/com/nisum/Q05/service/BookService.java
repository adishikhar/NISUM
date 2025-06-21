package com.nisum.Q05.service;


import com.nisum.Q05.model.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final Map<Long, Book> bookMap = new HashMap<>();
    private long currentId = 1;

    public List<Book> getAllBooks() {
        return new ArrayList<>(bookMap.values());
    }

    public Book getBookById(Long id) {
        return bookMap.get(id);
    }

    public Book addBook(Book book) {
        book.setId(currentId++);
        bookMap.put(book.getId(), book);
        return book;
    }

    public Book updateBook(Long id, Book book) {
        if (bookMap.containsKey(id)) {
            book.setId(id);
            bookMap.put(id, book);
            return book;
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        return bookMap.remove(id) != null;
    }

    public void clearAll() {
        bookMap.clear();
        currentId = 1;
    }
}

