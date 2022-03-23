package com.appLabIT.onlineLibrary.service;

import com.appLabIT.onlineLibrary.model.Book;
import com.appLabIT.onlineLibrary.model.Rent;
import com.appLabIT.onlineLibrary.model.User;

import java.util.Set;


public interface RentService {
    User rentBook(Integer userId, Set<Book> books);

    Rent returnBook(Integer rentId);
}
