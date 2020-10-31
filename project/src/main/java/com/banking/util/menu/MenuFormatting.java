package com.banking.util.menu;

public class MenuFormatting {
    // Format a menu with a title and menu options
    public static String createOptionsMenu(String title, String... options) {
        // Count the longest line in the menu so borders will be appropriate length
        int longest = 0;
        // Create Stringbuilder for the menu and add all of the options
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < options.length; i++) {
            String s = (i + 1 + ") " + options[i]);
            if (s.length() > longest) longest = s.length();
            sb.append(s + "\n");
        }

        sb.insert(0, "\n");

        String titleString = "| " + title + " |";
        longest = titleString.length() > longest ? titleString.length() : longest;

        //  Create menu border
        String border = "";
        for (int i = 0; i < longest + 2; i++) {
            border += ("=");
        }

        // Create Title StringBuilder
        StringBuilder sb2 = new StringBuilder(titleString);
        int titleMiddle = sb2.length() / 2;
        for (int i = 0; i < (border.length() / 2) - titleMiddle; i++) {
            sb2.insert(0, " ");
        }

        sb.insert(0, border);
        sb.append(border);


        sb.insert(0, sb2.toString() + "\n");
        sb.append("\nPlease select an option from above (1-" + options.length + ")\n");
        return "\n" + sb.toString();
    }
}
