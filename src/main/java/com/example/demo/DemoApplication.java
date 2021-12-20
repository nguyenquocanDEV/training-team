package com.example.demo;

import com.example.demo.entitiy.User;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
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

    @PostConstruct
    public void addData() {
//        List<Company> companies = Arrays.asList(
//            new Company("HHT", "Ha Noi"),
//                new Company("HHT1", "Ha Noi"),
//                new Company("HHT2", "Ha Noi"),
//                new Company("HHT3", "Ha Noi"),
//                new Company("HHT4", "Ha Noi"),
//                new Company("HHT5", "Ha Noi"),
//                new Company("HHT6", "Ha Noi")
//        );
//        companyRepository.saveAll(companies);

//        String[] companyId = {
//                "0eb3221d-a7f2-4c18-94d0-96b0ccfd35ee",
//                "1304f96e-121d-424b-bc36-ea7ff81b962d",
//                "154daba4-e3c6-4aee-b827-9b18f020800b",
//                "1e5cae94-9f2c-403f-9079-45234f10592c",
//                "3f6f329b-36fe-4277-afe2-eb722caae5e9",
//                "6e6d0b18-1051-45e6-8df2-e8ab4b806dd1",
//                "88353904-aae7-4f2d-8a3c-56b3bd6c7bf3"};
//
//
//        List<User> users = new ArrayList<>();
//
//        for (int i = 0; i < 50; i++) {
//            int position = new Random().nextInt(7);
//            User user = new User("Username" + Math.round(Math.random()), "Email" + Math.round(Math.random()), companyId[position]);
//            users.add(user);
//        }
//        userRepository.saveAll(users);

    }
}
