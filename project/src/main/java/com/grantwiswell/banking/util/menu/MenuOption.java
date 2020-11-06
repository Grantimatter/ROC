package com.grantwiswell.banking.util.menu;

import java.util.function.Consumer;

public class MenuOption {

    private String title = "untitled_command";
    private Consumer optionCommand;

    public MenuOption(String title, Consumer optionCommand) {
        this.title = title;
        this.optionCommand = optionCommand;
    }

    public void activateOption(){
        optionCommand.accept(1);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Consumer getOptionCommand() {
        return optionCommand;
    }

    public void setOptionCommand(Consumer optionCommand) {
        this.optionCommand = optionCommand;
    }
}
