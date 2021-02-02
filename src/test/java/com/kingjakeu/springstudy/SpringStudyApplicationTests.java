package com.kingjakeu.springstudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;

@SpringBootTest
class SpringStudyApplicationTests {

    @Test
    void contextLoads() {
        BigInteger a7 = new BigInteger("4294967294");
        BigInteger a8 = new BigInteger("4294967295");
        BigInteger a9 = new BigInteger("4294967296");
        BigInteger a10 = new BigInteger("2147483646");
        BigInteger a11 = new BigInteger("2147483647");
        BigInteger a12 = new BigInteger("2147483648");
        BigInteger a13 = new BigInteger("2147483649");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
        BigInteger a14 = new BigInteger("9223372036854775807");
        BigInteger a15 = a14.multiply(new BigInteger("2"));
        System.out.println(a15.toString());

        BigDecimal b1 = new BigDecimal("123.45");
        BigDecimal bb1 = new BigDecimal("1234512345.1234512");
        BigDecimal bb2 = new BigDecimal("123451234512345123");
        BigDecimal b2 = new BigDecimal("1234512345.12345123");
        BigDecimal b3 = new BigDecimal("1234512345.123451234");

        BigDecimal b4 = new BigDecimal("922337203.6854775806");
        BigDecimal b5 = new BigDecimal("9223372036854775807");
        BigDecimal b6 = new BigDecimal("922337203685477580.7");
        BigDecimal b7 = new BigDecimal("9223372036854775808");
        BigDecimal b8 = new BigDecimal("922337203685477580.8");
        BigDecimal b9 = new BigDecimal("18446744073709551614");
        BigDecimal b10 = new BigDecimal("184467440737095516.14");
        BigDecimal b11 = new BigDecimal("18446744073709551615");
        BigDecimal b12 = new BigDecimal("1844674407370955.1615");
        System.out.println(b4.toString());

        BigDecimal c1 = new BigDecimal("-999");
        BigDecimal c2 = new BigDecimal("8");
        BigDecimal c3 = c1.divide(c2);
        System.out.println(c3.toString());
        float fl = 1.32F;
        double d = 0.1;
        BigDecimal c5 = new BigDecimal(d);
        BigDecimal c4 = new BigDecimal(fl);
        System.out.println(c4.toString());
    }

    @Test
    public void doubleTest(){
        int i = 123;
        BigDecimal id = new BigDecimal(i);

        long l = 12345;
        BigDecimal ld = new BigDecimal(l);

        double d = 123.45;
        BigDecimal dd = new BigDecimal(d);

        String s = "1234";
        BigDecimal sd = new BigDecimal(s);

        char[] c = {'1', '2', '3'};
        BigDecimal cd = new BigDecimal(c);

        System.out.println(cd.toString());
    }

    @Test
    public void roundTest(){
        BigDecimal a = new BigDecimal("124.325");
        BigDecimal a1 = a.setScale(2, BigDecimal.ROUND_HALF_DOWN);
        BigDecimal a2 = a.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal a3 = a.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(a1.toString());
        System.out.println(a2.toString());
        System.out.println(a3.toString());
    }

    @Test
    public void operTest(){
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("3.0");
        BigDecimal add = a.add(b);
        BigDecimal sub = a.subtract(b);
        BigDecimal mul = a.multiply(b);
        BigDecimal div = a.divide(b, 2, BigDecimal.ROUND_DOWN);

        System.out.println(add.toString());
        System.out.println(sub.toString());
        System.out.println(mul.toString());
        System.out.println(div.toString());
    }

    @Test
    public void compTest(){
        BigDecimal a = new BigDecimal("1");
        BigDecimal b = new BigDecimal("20");


        BigDecimal d = new BigDecimal("0.0000005");
        System.out.println(d.toString());
        System.out.println(d.toPlainString());
        System.out.println(a.compareTo(b));
    }
}