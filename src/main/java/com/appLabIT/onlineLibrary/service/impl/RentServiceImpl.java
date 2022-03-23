package com.appLabIT.onlineLibrary.service.impl;

import com.appLabIT.onlineLibrary.model.Book;
import com.appLabIT.onlineLibrary.model.Rent;
import com.appLabIT.onlineLibrary.model.User;
import com.appLabIT.onlineLibrary.model.enums.BookType;
import com.appLabIT.onlineLibrary.repository.BookRepository;
import com.appLabIT.onlineLibrary.repository.RentRepository;
import com.appLabIT.onlineLibrary.repository.UserRepository;
import com.appLabIT.onlineLibrary.service.RentService;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class RentServiceImpl implements RentService {

    private final RentRepository rentRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public RentServiceImpl(RentRepository rentRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.rentRepository = rentRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }
    @Override
    public User rentBook(Integer userId, Set<Book> book) {
        var existingUser = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        if(book.size() < 6){
            for (Book borrowed : book) {
                Rent newRent = new Rent(existingUser, borrowed);
                if(checkNumberOfBooks(borrowed) && userBookCounter(existingUser)
                        && checkBookType(existingUser.getRents()) ) {
                    newRent.setStartRent(Instant.now());
                    existingUser.getRents().add(newRent);
                    userRepository.save(existingUser);
                    rentRepository.save(newRent);
                }
            }
        }else {
            throw new IllegalArgumentException("You can't borrow more then five books!");
        }
        return existingUser;

    }
    @Override
    public Rent returnBook(Integer rentId) {
        var rent = rentRepository.findById(rentId)
                .orElseThrow(IllegalArgumentException::new);

        if(checkNumberOfBooksAfterRents(rent.getBook()) && userReturnBookCounter(rent.getUser())) {
            rent.setEndRent(Instant.now());
            rentRepository.save(rent);
        }else{
            throw new IllegalArgumentException("You can't borrow this book!");
        }
        return rent;
    }

    public boolean checkNumberOfBooks(Book book){
        int counter = book.getNumberOfBooks();
        if(counter == 0){
            throw new IllegalArgumentException("This book is not available");
        }
        book.setNumberOfBooks(counter - 1);
        return true;
    }
    public boolean checkNumberOfBooksAfterRents(Book book){
        int counter = book.getNumberOfBooks();
        book.setNumberOfBooks(counter + 1);
        return true;
    }
    public boolean userBookCounter(User user){
        int counter = user.getBorrowBookCounter();
        if(counter == 7){
            throw new IllegalArgumentException("You can't borrow new book because you already borrowed 7 books");
        }
        user.setBorrowBookCounter(counter + 1);
        return true;
    }
    public boolean userReturnBookCounter(User user){
        int counter = user.getBorrowBookCounter();
        user.setBorrowBookCounter(counter - 1);
        return true;
    }
    public boolean checkBookType(Set<Rent> rents){
        int newTypeCounter = 0;
        for (Rent ignored : rents) {
            if(ignored.getBook().getBookType() == BookType.New){
                newTypeCounter++;
            }
        }
        if (newTypeCounter >= 2){
            return false;
        }
        return true;
    }


}
