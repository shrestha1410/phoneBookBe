package com.phoneBook.repository;

import com.phoneBook.entity.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByMobileNumberAndPassword(Long mobileNumber,String password);
    Optional<User> findByMobileNumber(Long mobileNumber);
}
