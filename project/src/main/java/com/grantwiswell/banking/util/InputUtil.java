package com.grantwiswell.banking.util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static String getStringInput(){
        String str = scanner.nextLine();
        return isValidInput(str) ? str : null;
    }

    public static int getIntInput(){
        String str = scanner.nextLine();
        try {
            int input = Integer.parseInt(str);
            return isValidInput(str) ? Integer.parseInt(str) : 0;
        } catch (NumberFormatException e) {
            System.out.println("Please input an integer value (0-9... etc.)");
        }
        return 0;
    }

    public static double getDoubleInput(){
        String str = scanner.nextLine();
        return isValidInput(str) ? Double.parseDouble(str) : 0d;
    }

    private static boolean isValidInput(String str){
        return (str != null && str.length() > 0) ? true : false;
    }
}
