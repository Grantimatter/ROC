package com.grantwiswell.banking.util;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class InputUtil {
    private static Scanner scanner = new Scanner(System.in);
    private static Logger log = Logger.getLogger(InputUtil.class);
    private static String messagePrompt = "";

    public static String getStringInput(){
        log.info(messagePrompt);
        String str = scanner.nextLine();
        log.debug("User Input: " + str);
        clearMessagePrompt();
        return isValidInput(str) ? str: " ";
    }

    public static int getIntInput(){
        log.info(messagePrompt);
        String str = scanner.nextLine();
        log.debug("User Input: " + str);
        try {
            int input = Integer.parseInt(str);
            clearMessagePrompt();
            return isValidInput(str) ? Integer.parseInt(str): 0;
        } catch (NumberFormatException e) {
            log.info("Please input an integer value (0-9... etc.)");
        }
        clearMessagePrompt();
        return 0;
    }

    public static double getDoubleInput(){
        log.info(messagePrompt);
        String str = scanner.nextLine();
        log.debug("User Input: " + str);
        double inputDouble = 0;
        try{
            inputDouble = Double.parseDouble(str);
        } catch (NumberFormatException e) {
            InputUtil.setMessagePrompt("You must enter a valid number!");
        }
        clearMessagePrompt();
        return inputDouble;
    }

    public static void setMessagePrompt(String message){
        messagePrompt = message;
    }
    private static void clearMessagePrompt(){
        messagePrompt ="";
    }

    private static boolean isValidInput(String str){
        return (str != null && str.length() > 0) ? true: false;
    }
}
