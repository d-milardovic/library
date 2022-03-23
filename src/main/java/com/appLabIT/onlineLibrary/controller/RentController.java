package com.appLabIT.onlineLibrary.controller;

import com.appLabIT.onlineLibrary.model.Book;
import com.appLabIT.onlineLibrary.model.Rent;
import com.appLabIT.onlineLibrary.model.User;
import com.appLabIT.onlineLibrary.service.RentService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/library")
public class RentController {
    private final RentService rentService;

    public RentController(RentService rentService) {
        this.rentService = rentService;
    }
    @RequestMapping(value = "/rentBook/user/{userId}", method = RequestMethod.POST)
    public User userBorrowBook(@PathVariable Integer userId, @RequestBody Set<Book> books){
        return rentService.rentBook(userId, books);
    }
    @RequestMapping(value = "/rentBack/{rentId}", method = RequestMethod.PUT)
    public Rent returnBook(@PathVariable Integer rentId){
        return rentService.returnBook(rentId);
    }
}
