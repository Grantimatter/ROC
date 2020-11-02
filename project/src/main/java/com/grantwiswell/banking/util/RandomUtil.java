package com.grantwiswell.banking.util;

public class RandomUtil {
    public static int generateAccountNumber(){
        return (int) ((Math.random()) * (999999 - 100000) + 100000);
    }

    public static int generateRandomId(){
        return (int) (Math.random() * (999-100) + 100);
    }
}
