package com.example.demo;

import com.example.demo.entitiy.Company;
import com.example.demo.entitiy.User;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepository companyRepository;

    //chay xong thi update trong file config
//    spring.jpa.hibernate.ddl-auto = none
//    @PostConstruct
//    public void addData() {
//        Faker faker = new Faker();
//        for (int i = 0; i < 10; i++) {
//            Company company = new Company(
//                    faker.funnyName().name(),
//                    faker.address().fullAddress()
//            );
//            companyRepository.save(company);
//            for (int j = 0; j < 10; j++) {
//                User user = new User(
//                        faker.superhero().name(),
//                        faker.address().secondaryAddress(),
//                        company.getId()
//                );
//                userRepository.save(user);
//            }
//        }
//    }
}
