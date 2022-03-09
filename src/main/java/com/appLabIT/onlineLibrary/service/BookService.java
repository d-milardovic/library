package com.appLabIT.onlineLibrary.service;

import com.appLabIT.onlineLibrary.model.Book;
import com.appLabIT.onlineLibrary.model.dto.BookDto;

public interface BookService {
    Book addBook(BookDto bookDto);

    void deleteBook(Integer bookId);
}
