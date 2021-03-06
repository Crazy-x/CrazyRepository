package com.crazy.test;

import com.crazy.coding.Application;
import com.crazy.coding.config.cache.RedisCache;
import com.crazy.coding.mapper.UserMapper;
import io.github.jhipster.config.JHipsterProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

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

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    @Test
    public void Incr() {

//        RedisCache.increment("id", 1);
//
//        String id = (String) RedisCache.getIncrValue("id");
//
//        List<String> list = new ArrayList<>();
//        list.add("1111");
//        list.add("2222");
//        list.add("3333");
//        list.forEach(str -> {
//            System.out.println(str);
//        });

    }

    @Test
    public void Test() {

//        List<User> userList = userMapper.findUserList();
//
//        User user = userList.get(0);
//
//        RedisCache.put("user", user);
//
//        RedisCache.put(user.getAccount(), user.getAccount());
//
//        User user1 = (User) RedisCache.get("user");
//
//        System.out.println(user1.getAccount());
//
//
//        System.out.println(jHipsterProperties.getCors().getAllowedMethods().size());
    }

}


