package com.example.demo.repositories;

import com.test.soaptest.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Integer> {
    Optional<User> findUserByName(String name);
}
