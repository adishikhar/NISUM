package com.library.bookservice.service;



import com.library.bookservice.dto.BookDTO;
import java.util.List;

public interface BookService {
    BookDTO save(BookDTO bookDTO);
    BookDTO getById(Long id);
    List<BookDTO> getAll();
    BookDTO update(Long id, BookDTO bookDTO);
    void delete(Long id);
}

