package com.appLabIT.onlineLibrary.service;

import com.appLabIT.onlineLibrary.model.User;
import com.appLabIT.onlineLibrary.model.dto.UserDto;

public interface UserService {
    User addUser(UserDto userDto);

    void deleteUser(Integer userId);
}
