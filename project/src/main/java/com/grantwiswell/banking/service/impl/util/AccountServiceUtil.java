package com.grantwiswell.banking.service.impl.util;

public class AccountServiceUtil {
    public static boolean validateStatus(String status) {
        if (status.equalsIgnoreCase("ACCEPTED") || status.equalsIgnoreCase("REJECTED") || status.equalsIgnoreCase("PENDING"))
            return true;
        return false;
    }
}
