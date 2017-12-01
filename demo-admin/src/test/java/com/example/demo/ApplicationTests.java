package com.example.demo;

import com.example.demo.cache.RedisCache;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void Test() {

        List<User> userList = userMapper.findUserList();

        User user = userList.get(0);

        RedisCache.put(user.getAccount(), user.getAccount());

        RedisCache.put("age", user.getAge());

        String account = (String) RedisCache.get("account");

        System.out.println(account);
    }
}
