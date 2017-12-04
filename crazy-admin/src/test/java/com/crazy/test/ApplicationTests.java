package com.crazy.test;

import com.crazy.coding.Application;
import com.crazy.coding.cache.RedisCache;
import com.crazy.coding.entity.User;
import com.crazy.coding.mapper.UserMapper;
import io.github.jhipster.config.JHipsterProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * 测试类
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Resource
    private JHipsterProperties jHipsterProperties;

    @Test
    public void Test() {
//        List<User> userList = userMapper.findUserList();
//
//        User user = userList.get(0);
//
//        RedisCache.put("user", user);
//
//        RedisCache.put("age", user.getAge());
//
//        RedisCache.put(user.getAccount(), user.getAccount());
//
//        User user1 = (User) RedisCache.get("user");
//
//        System.out.println(user1.getAccount());

        System.out.println(jHipsterProperties.getCors().getAllowedMethods().size());
    }
}


