package com.grantwiswell.banking.view;

import com.grantwiswell.banking.main.menu.MenuFormatting;
import com.grantwiswell.banking.model.Transaction;
import com.grantwiswell.banking.util.InputUtil;
import org.apache.log4j.Logger;

import java.util.List;

//TODO MVC design pattern not implemented
public class TransactionView {
    private static Logger log = Logger.getLogger(TransactionView.class);

    public int viewMainTransactionList(List<Transaction> transactionList){
        log.info(MenuFormatting.createOptionsMenu("Transfers",createOptionStringArray(transactionList)));
        return InputUtil.getIntInput();
    }

    public void viewCompletedTransactionList(List<Transaction> transactionList){
        int choice = InputUtil.getIntInput();
    }

    private String[] createOptionStringArray(List<Transaction> transactionList){
        String[] optionStringArray = new String[transactionList.size()];
        for (int i = 0; i < transactionList.size(); i++) {
            optionStringArray[i] = transactionList.get(i).toString();
        }
        optionStringArray[transactionList.size() + 1] = "Return";
        return optionStringArray;
    }
}
