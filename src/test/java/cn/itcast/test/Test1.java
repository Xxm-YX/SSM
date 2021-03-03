package cn.itcast.test;

import org.junit.Test;

import java.security.SecureRandom;

public class Test1 {

    /**
     * 随机数
     */
    @Test
    public void Test1(){
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < 10; i++) {
            System.out.println(r.nextInt(2));
        }
    }


}
