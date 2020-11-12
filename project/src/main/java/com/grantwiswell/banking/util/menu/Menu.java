package com.grantwiswell.banking.util.menu;

import com.grantwiswell.banking.util.InputUtil;
import com.grantwiswell.banking.util.ScreenUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Menu {

    private static Logger log = Logger.getLogger(Menu.class);

    protected List<MenuOption> menuOptionList = new ArrayList<>();
    protected Consumer beforePrintConsumer;
    protected Consumer afterPrintConsumer;
    protected boolean isLooping = true;
    protected boolean hasRowDividers = false;
    protected String title = "Menu";
    protected String exitOption = "Exit";

    public Menu(String title){
        this.title = title;
    }

    public Menu(String title, String exitOption){
        this(title);
        this.exitOption = exitOption;
    }

    public Menu(String title, String exitOption, List<MenuOption> menuOptionList) {
        this(title, exitOption);
        this.menuOptionList = menuOptionList;
    }

    public void startMenu() {
        // Put the titles of the options into an array;
        String[] optionTitleArray = new String[menuOptionList.size()];
        for (int i = 0; i < optionTitleArray.length; i++) {
            optionTitleArray[i] = menuOptionList.get(i).getTitle();
        }

        // Print the menu to the console and log
        int choice = 0;
        do {
            // Run a command before printing is started if one is supplied
            if(beforePrintConsumer != null) beforePrintConsumer.accept(1);
            ScreenUtil.clearScreen();
            log.info(MenuFormatting.createOptionsMenu(title, exitOption, hasRowDividers, optionTitleArray));
            log.info("Please Select an option (1-" + (optionTitleArray.length + 1) + ")\n");

            // Get the user input
            choice = InputUtil.getIntInput();

            // Use the user input to select the menu option
            if (choice > 0 && choice <= menuOptionList.size()) {
                menuOptionList.get(choice - 1).activateOption();
            } else if(choice > menuOptionList.size() + 1 || choice <= 0) {
                // Warn user of choice that is not available
                InputUtil.setMessagePrompt("Please select a valid option (1 - " + (menuOptionList.size() + 1) + ")");
            }

            // Run a command after printing is completed if one is supplied
            if(afterPrintConsumer != null && choice != menuOptionList.size() + 1) afterPrintConsumer.accept(1);
        }while(isLooping && choice != menuOptionList.size() + 1);
    }

    public void beforePrint(){
        if(beforePrintConsumer != null)
            beforePrintConsumer.accept(1);
    }

    public void afterPrint(){
        if(afterPrintConsumer != null)
            afterPrintConsumer.accept(1);
    }

    public Menu setIsLooping(boolean isLooping){
        this.isLooping = isLooping;
        return this;
    }

    public Consumer getBeforePrintConsumer() {
        return beforePrintConsumer;
    }

    public void setBeforePrintConsumer(Consumer beforePrintConsumer) {
        this.beforePrintConsumer = beforePrintConsumer;
    }

    public Consumer getAfterPrintConsumer() {
        return afterPrintConsumer;
    }

    public void setAfterLoopConsumer(Consumer afterPrintConsumer) {
        this.afterPrintConsumer = afterPrintConsumer;
    }

    public Menu setTitle(String title) {
        this.title = title;
        return this;
    }

    public Menu addOption(MenuOption menuOption) {
        menuOptionList.add(menuOption);
        return this;
    }

    public Menu addOptions(List<MenuOption> menuOptionList){
        this.menuOptionList.addAll(menuOptionList);
        return this;
    }

    public Menu addOption(String title, Consumer consumer){
        menuOptionList.add(new MenuOption(title, consumer));
        return this;
    }

    public Menu setExitOption(String option) {
        exitOption = option;
        return this;
    }

    public Menu setHasRowDividers(boolean hasRowDividers){
        this.hasRowDividers = hasRowDividers;
        return this;
    }
}
