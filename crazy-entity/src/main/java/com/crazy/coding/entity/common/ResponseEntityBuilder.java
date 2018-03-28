package com.crazy.coding.entity.common;

import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

public class ResponseEntityBuilder {

    public static ResponseEntity<Result> build(Result result) {
        return new ResponseEntity<Result>(result, OK);
    }

    public static ResponseEntity<Result> build(boolean success) {
        return new ResponseEntity<Result>(new Result(success), OK);
    }

    public static ResponseEntity<Result> build(int count) {
        return new ResponseEntity<Result>(new Result(true, count), OK);
    }

    public static ResponseEntity<Result> build(List<?> list) {
        return new ResponseEntity<Result>(new Result(true, list), OK);
    }

    public static ResponseEntity<Result> build(boolean success, String message) {
        return new ResponseEntity<Result>(new Result(success, message), OK);
    }

    public static ResponseEntity<Result> build(boolean success, Object data) {
        return new ResponseEntity<Result>(new Result(success, data), OK);
    }

    public static <T> ResponseEntity<PageResult> build(Page<T> page) {
        return build(page, true, OK);
    }

    /**
     *
     */
    public static <T> ResponseEntity<PageResult> build(Page<T> page, boolean success, HttpStatus status) {
        PageResult result = new PageResult();
        result.setSuccess(success);
        result.setCurrent(page.getCurrent());
        result.setPages(page.getPages());
        result.setSize(page.getSize());
        result.setTotal(page.getTotal());
        result.setData(page.getRecords());

        ResponseEntity<PageResult> entity = new ResponseEntity<PageResult>(result, status);
        return entity;
    }
}
