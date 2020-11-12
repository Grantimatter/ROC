package com.grantwiswell.banking.util;

public class RandomUtil {
    public static int generateAccountNumber() {
        return (int) ((Math.random()) * (999999 - 100000) + 100000);
    }

    public static int getRandomInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
