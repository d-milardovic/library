package com.appLabIT.onlineLibrary.service.impl;

import com.appLabIT.onlineLibrary.model.Book;
import com.appLabIT.onlineLibrary.model.dto.BookDto;
import com.appLabIT.onlineLibrary.repository.BookRepository;
import com.appLabIT.onlineLibrary.service.BookService;

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public Book addBook(BookDto bookDto) {

        Book newBook = new Book();
        newBook.setName(bookDto.getName());
        newBook.setAuthor(bookDto.getAuthor());

        bookRepository.save(newBook);
        return newBook;
    }

    @Override
    public void deleteBook(Integer bookId) {
        bookRepository.deleteById(bookId);
    }
}
