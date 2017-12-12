package com.crazy.test;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertTrue;


public class NewTest {


    private BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();

    private String str = "crazy-code";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void Incr() {
        redisTemplate.opsForValue().increment("id", 1);

        Long id = (Long) redisTemplate.opsForValue().get("id");

        System.out.println(id);
    }

    @Test
    public void Math() {
        int number = 15;
        double i = 1 - 0.9;

        System.out.println(i);
        if (i == 0.1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }


    @Test
    public void Test() {

        String password = encryptor.encryptPassword(str);

        System.out.println(password);

        // 断言函数：结果为true则测试通过
        assertTrue("结果为false!", encryptor.checkPassword(str, password));

    }

    @Test
    public void remove() {
        String s = "0-1-2-3-4-5-6";

        String[] strs = StringUtils.split(s, "-");

        List<String> strlist = Arrays.asList(strs);

        List<String> list = new ArrayList<>(strlist);

        Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            String item = iter.next();
            if (item.equals("1")) {
                iter.remove();
            }
        }

        for (String str : list) {
            System.out.print(str);
        }
    }
}
