package com.appLabIT.onlineLibrary.service.impl;

import com.appLabIT.onlineLibrary.model.User;
import com.appLabIT.onlineLibrary.model.dto.UserDto;
import com.appLabIT.onlineLibrary.repository.UserRepository;
import com.appLabIT.onlineLibrary.service.UserService;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(UserDto userDto) {

        User newUser = new User();
        newUser.setEmail(userDto.getEmail());
        newUser.setLastName(userDto.getLastName());
        newUser.setName(userDto.getName());

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
