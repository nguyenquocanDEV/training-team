package com.example.demo.dtos.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private String companyName;
    private Long createAt;
    private Boolean isDeleted;
}
