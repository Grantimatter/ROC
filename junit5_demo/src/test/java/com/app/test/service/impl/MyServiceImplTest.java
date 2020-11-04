package com.app.test.service.impl;

import com.app.test.service.MyService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyServiceImplTest {

    private static MyService service;

    @BeforeAll
    public static void setUpService(){
        service = new MyServiceImpl();
    }

    @Test
    void testIsValidPrimeNumber() {
        for(int i = 1; i < 1001; i+=2){
            boolean b = service.isValidPrimeNumber(i);
            assertTrue(b);
        }
    }

    @Test
    void testIsValidPrimeNumber2() {
        for(int i = 2; i < 1000; i+=2){
            boolean b = service.isValidPrimeNumber(i);
            assertFalse(b);
        }
    }

    @Test
    void isValidPhoneNumber() {
        fail("Not yet implemented");
    }
}