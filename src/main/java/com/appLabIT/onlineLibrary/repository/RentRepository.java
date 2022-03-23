package com.appLabIT.onlineLibrary.repository;

import com.appLabIT.onlineLibrary.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends JpaRepository<Rent,Integer> {
    Rent findByUserId(Integer userId);
}
