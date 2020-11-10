package com.grantwiswell.banking.util;

public class FormatStrings {

    public static String formatPhoneNumber(long number){
        return(String.valueOf(number).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3"));
    }

}
