package com.example.demo.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageReq {
    private Integer page; //page hien tai
    private Integer pageSize; //so phan tu 1 trang
    private String order; //sap xep theo thu tu gi
    private String orderBy; //sap xep theo truong gi
}
