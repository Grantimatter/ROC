package com.grantwiswell.banking.util;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);
    private static Logger log = Logger.getLogger(InputUtil.class);

    public static String getStringInput(){
        System.out.print(": ");
        String str = scanner.nextLine();
        log.debug("User Input : " + str);
        return isValidInput(str) ? str : null;
    }

    public static int getIntInput(){
        System.out.print(": ");
        String str = scanner.nextLine();
        log.debug("User Input : " + str);
        try {
            int input = Integer.parseInt(str);
            return isValidInput(str) ? Integer.parseInt(str) : 0;
        } catch (NumberFormatException e) {
            log.info("Please input an integer value (0-9... etc.)");
        }
        return 0;
    }

    public static double getDoubleInput(){
        System.out.print(": ");
        String str = scanner.nextLine();
        log.debug("User Input : " + str);
        double inputDouble = 0;
        try{
            inputDouble = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            log.warn("You must enter a valid number!");
        }
        return inputDouble;
    }

    private static boolean isValidInput(String str){
        return (str != null && str.length() > 0) ? true : false;
    }
}
