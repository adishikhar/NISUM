package com.library.bookservice.util;



import com.library.bookservice.dto.BookDTO;
import com.library.bookservice.entity.Book;

public class MapperUtil {
    public static BookDTO toDto(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .publishedYear(book.getPublishedYear())
                .build();
    }

    public static Book toEntity(BookDTO dto) {
        return Book.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .publishedYear(dto.getPublishedYear())
                .build();
    }
}

