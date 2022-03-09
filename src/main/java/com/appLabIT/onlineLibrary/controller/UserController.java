package com.appLabIT.onlineLibrary.controller;

import com.appLabIT.onlineLibrary.model.User;
import com.appLabIT.onlineLibrary.model.dto.UserDto;
import com.appLabIT.onlineLibrary.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User addUser(@RequestBody UserDto userDto){
        return userService.addUser(userDto);
    }

    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer userId){ userService.deleteUser(userId);}
}
