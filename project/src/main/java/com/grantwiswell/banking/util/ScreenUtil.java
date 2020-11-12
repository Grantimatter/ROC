package com.grantwiswell.banking.util;

public class ScreenUtil {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
