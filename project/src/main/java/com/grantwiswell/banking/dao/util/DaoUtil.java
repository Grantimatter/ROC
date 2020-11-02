package com.grantwiswell.banking.dao.util;

public class DaoUtil {

    private static final String INTERNAL_ERROR = "Internal error... Please contact SYSADMIN for assistance";

    public static void internalError(Exception e){
        System.out.println(DaoUtil.INTERNAL_ERROR + e != null ? "\n" + e.getMessage() : "");
    }
}
