package com.example.demo.utils;

import com.example.demo.dtos.request.PageReq;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Objects;
import java.util.Optional;

public class PaginationUtils {

    public static Pageable getPageReq(PageReq pageReq) {
        Integer page = Optional.ofNullable(pageReq.getPage()).orElse(1);
        page--;
        Integer pageSize = Optional.ofNullable(pageReq.getPageSize()).orElse(10);
        String order = Optional.ofNullable(pageReq.getOrder()).orElse("desc");
        String orderBy = Optional.ofNullable(pageReq.getOrder()).orElse("id");
        Sort sort = Objects.equals(order, "asc") ? Sort.by(orderBy).ascending() : Sort.by(orderBy).descending();

        return PageRequest.of(page, pageSize, sort);
    }

}
