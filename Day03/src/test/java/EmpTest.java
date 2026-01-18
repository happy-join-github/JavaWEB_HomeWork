package com.xky.www;

import com.xky.www.service.EmpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


public class EmpTest {
    EmpService empService = new EmpService();
    @Test
    public void UserService1Test() {
        // 基于 @Test 注解，完成下面5个方法的单元测试程序编写，输出测试结果 。
        // isBeijing
        System.out.println(empService.isBeijing("510310198812120931"));
        // getAge
        System.out.println(empService.getAge("510310198812120931"));
        // getGender
        System.out.println(empService.getGender("510310198812120931"));
        //getYear
        System.out.println(empService.getYear("610110201909091231"));
        //getMonth
        System.out.println(empService.getMonth("510310198812120931"));

    }
    @ParameterizedTest
    @ValueSource(strings = {"610110201909091231","110110201509091109","510310198812120931"})
    public void UserService2Test(String idcard) {
        // 基于参数化测试注解 @ParameterizedTest ，输出测试结果 。
        System.out.println(empService.isBeijing(idcard));
        System.out.println(empService.getAge(idcard));
        System.out.println(empService.getGender(idcard));
        System.out.println(empService.getYear(idcard));
        System.out.println(empService.getMonth(idcard));
    }

    @Test
    public void UserService3Test() {
        // 基于 @Test 注解，完成下面5个方法的单元测试程序编写【基于断言方式】
        Assertions.assertFalse(empService.isBeijing("510310198812120931"));
        Assertions.assertEquals(37, empService.getAge("510310198812120931"));
        Assertions.assertEquals("男", empService.getGender("510310198812120931"));
        Assertions.assertEquals("2019", empService.getYear("610110201909091231"));
        Assertions.assertEquals("12", empService.getMonth("510310198812120931"));
    }
}
