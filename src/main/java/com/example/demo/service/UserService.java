package com.example.demo.service;

import com.example.demo.dtos.dto.PageRes;
import com.example.demo.dtos.dto.Res;
import com.example.demo.dtos.request.PageReq;
import com.example.demo.dtos.response.UserResponse;
import com.example.demo.entitiy.User;

import java.util.List;

public interface UserService {
    public PageRes<UserResponse> getAll(PageReq pageReq);

    public Res<?> deleteById(String id);
}
