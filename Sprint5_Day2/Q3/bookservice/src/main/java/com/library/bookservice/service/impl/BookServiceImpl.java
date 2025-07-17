package com.library.bookservice.service.impl;

import com.library.bookservice.dto.BookDTO;
import com.library.bookservice.entity.Book;
import com.library.bookservice.exception.BookNotFoundException;
import com.library.bookservice.util.MapperUtil;
import com.library.bookservice.repository.BookRepository;
import com.library.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation class for BookService.
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * Retrieves all books from the repository.
     *
     * @return list of BookDto
     */
    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::toDto)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves a book by its ID.
     *
     * @param id the book ID
     * @return BookDto
     * @throws BookNotFoundException if book is not found
     */
    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        return BookMapper.toDto(book);
    }

    /**
     * Saves a new book in the repository.
     *
     * @param bookDto the book to save
     * @return BookDto
     */
    @Override
    public BookDTO createBook(BookDTO bookDto) {
        Book book = BookMapper.toEntity(bookDto);
        Book saved = bookRepository.save(book);
        return BookMapper.toDto(saved);
    }

    /**
     * Updates an existing book.
     *
     * @param id      the ID of the book to update
     * @param bookDto the new book data
     * @return BookDto
     * @throws BookNotFoundException if book is not found
     */
    @Override
    public BookDTO updateBook(Long id, BookDTO bookDto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setPublishedDate(bookDto.getPublishedDate());
        Book updated = bookRepository.save(book);
        return BookMapper.toDto(updated);
    }

    /**
     * Deletes a book by its ID.
     *
     * @param id the ID of the book to delete
     * @throws BookNotFoundException if book is not found
     */
    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException(id);
        }
        bookRepository.deleteById(id);
    }
}
