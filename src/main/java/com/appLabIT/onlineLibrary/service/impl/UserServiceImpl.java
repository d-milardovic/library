package com.appLabIT.onlineLibrary.service.impl;

import com.appLabIT.onlineLibrary.model.User;
import com.appLabIT.onlineLibrary.model.dto.UserDto;
import com.appLabIT.onlineLibrary.repository.UserRepository;
import com.appLabIT.onlineLibrary.service.UserService;

import java.util.HashSet;
import java.util.Optional;


public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(UserDto userDto) {

        User newUser = new User();
        newUser.setName(userDto.getName());
        newUser.setLastName(userDto.getLastName());
        newUser.setEmail(userDto.getEmail());
        newUser.setBorrowBookCounter(0);
        newUser.setRents(new HashSet<>());

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Optional<User> updateUser(Integer userId, UserDto userDto) {
        Optional<User> updateUser = userRepository.findById(userId);

        updateUser.get().setName(userDto.getName());
        updateUser.get().setLastName(userDto.getLastName());
        updateUser.get().setEmail(userDto.getEmail());
        updateUser.ifPresent(userRepository::save);
        return updateUser;
    }
}
