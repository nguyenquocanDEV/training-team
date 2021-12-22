package com.example.demo.controller;

import com.example.demo.dtos.dto.PageRes;
import com.example.demo.dtos.dto.Res;
import com.example.demo.dtos.request.PageReq;
import com.example.demo.dtos.response.UserResponse;
import com.example.demo.entitiy.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<PageRes<UserResponse>> getAll(PageReq pageReq) {
        return ResponseEntity.ok(userService.getAll(pageReq));
    }
    @GetMapping("/search")
    public ResponseEntity<PageRes<UserResponse>> search(
        PageReq pageReq,
        @RequestParam(value = "username", required = false) String username,
        @RequestParam(value = "email", required = false) String email,
        @RequestParam(value = "companyName", required = false) String companyName) {
        return ResponseEntity.ok(userService.search(pageReq,username,email,companyName));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Res<?>> delete(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteById(id));
    }

    @GetMapping("/export")
    public ResponseEntity<Void> exportExcel(HttpServletResponse response) {
        userService.exportExcel(response);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
