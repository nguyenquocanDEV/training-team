package com.example.demo.repository;

import com.example.demo.entitiy.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
}
