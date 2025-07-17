package com.library.bookservice.exception;



/**
 * Exception thrown when a requested book is not found in the database.
 */
public class BookNotFoundException extends RuntimeException {

    /**
     * Constructs a new BookNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public BookNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new BookNotFoundException with a default message and the specified book ID.
     *
     * @param bookId the ID of the book that was not found
     */
    public BookNotFoundException(Long bookId) {
        super("Book with ID " + bookId + " not found.");
    }
}

