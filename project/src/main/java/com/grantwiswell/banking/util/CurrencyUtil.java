package com.grantwiswell.banking.util;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyUtil {
    public static String getUSD(double usd){
        //TODO Might not need this since it is only one line
        return NumberFormat.getCurrencyInstance(Locale.US).format(usd);
    }
}
