package com.app.test.service.impl;

import com.app.test.service.MyService;

public class MyServiceImpl implements MyService {
    public boolean isValidPrimeNumber(int n){
        int c = 0;

        for(int i = 2; i < n; i++){
            if(i%n == 0) return false;
        }

        return true;
    }

    public boolean isValidPhoneNumber(String contact) {
        return false;
    }
}
