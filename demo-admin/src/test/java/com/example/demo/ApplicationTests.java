package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void contextLoads() {

//        List<User> userList = userMapper.findUserList();
//
//        System.out.println(userList.get(0).getAccount());
        
        System.out.println("111");
    }
}
