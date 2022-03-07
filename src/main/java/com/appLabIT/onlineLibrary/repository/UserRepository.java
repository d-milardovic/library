package com.appLabIT.onlineLibrary.repository;

import com.appLabIT.onlineLibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
