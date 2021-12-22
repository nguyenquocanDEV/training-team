package com.example.demo.repository;

import com.example.demo.entitiy.User;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User, String> {
  Page<User> findByUsernameWithinOrEmailWithinOrCompany_NameWithin(Pageable pageable,String username, String email, String companyName);


}
