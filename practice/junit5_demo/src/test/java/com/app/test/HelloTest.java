package com.app.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloTest {
    @BeforeAll
    public static void helloBeforeAll(){
        System.out.println("Hello from @BeforeAll");
    }

    @BeforeEach
    public void helloBeforeEach(){
        System.out.println("Hello from @BeforeEach, this will be executed before every test case in this class");
    }

    @AfterEach
    public void helloAfterEach(){
        System.out.println("Hello from @BeforeEach, this will be executed before every test case in this class");
    }

    @Test
    public void testHelloTest1(){
        System.out.println("Hello from helloTest()");
    }

    @Test
    public void testHelloTest2(){
        System.out.println("Hello from helloTest()");
    }

    @AfterAll
    public static void helloAfterAll(){
        System.out.println("Hello from @AfterAll");
    }
}
