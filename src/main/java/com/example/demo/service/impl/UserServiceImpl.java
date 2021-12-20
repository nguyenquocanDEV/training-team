package com.example.demo.service.impl;

import com.example.demo.dtos.dto.PageRes;
import com.example.demo.dtos.dto.Pages;
import com.example.demo.dtos.dto.Res;
import com.example.demo.dtos.request.PageReq;
import com.example.demo.dtos.response.UserResponse;
import com.example.demo.entitiy.User;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public PageRes<UserResponse> getAll(PageReq pageReq) {
        Pageable pageable = PaginationUtils.getPageReq(pageReq);
        Page<User> userPage = userRepository.findAll(pageable);
        List<UserResponse> users = new ArrayList<>();

        userPage.getContent().forEach(user -> {
            UserResponse userResponse = UserResponse.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .email(user.getEmail())
                    .createAt(user.getCreateAt())
                    .companyName(companyRepository.findById(user.getCompanyId()).get().getName())
                    .build();
            users.add(userResponse);
        });
        Pages pages = new Pages(
                userPage.getTotalElements(),
                userPage.getSize(),
                userPage.getNumber() + 1
        );
        return new PageRes<UserResponse>(users, pages, "User List", HttpStatus.OK);
    }

    @Override
    public Res<?> deleteById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.deleteById(id);
            return new Res<String>("Deleted!", HttpStatus.OK);
        }
        return new Res<String>("Not found!", HttpStatus.NOT_FOUND);
    }

}
