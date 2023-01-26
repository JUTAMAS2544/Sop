package com.example.userservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query(value = "select * from User where email = :email and password = :password", nativeQuery = true)
    public User LogIn(String email, String password);
}
