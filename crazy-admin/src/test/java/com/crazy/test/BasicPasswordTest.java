package com.crazy.test;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class BasicPasswordTest {


    private BasicPasswordEncryptor encryptor = new BasicPasswordEncryptor();

    private String str = "crazy-code";

    @Test
    public void Test() {

        String password = encryptor.encryptPassword(str);

        System.out.println(password);

        // 断言函数：结果为true则测试通过
        assertTrue("结果为false!", encryptor.checkPassword(str, password));

    }
}
