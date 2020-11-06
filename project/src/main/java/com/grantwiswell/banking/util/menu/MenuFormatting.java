package com.grantwiswell.banking.util.menu;

public class MenuFormatting {
    // Format a menu with a title and menu options
    public static String createOptionsMenu(String title, String exitOption, String... options) {
        // Count the longest line in the menu so borders will be appropriate length
        int longest = 0;
        // UNICODE Characters
        char topLeftCornerChar = '\u250C';
        char topRightCornerChar = '\u2510';
        char bottomLeftCornerChar = '\u2514';
        char bottomRightCornerChar = '\u2518';
        char wallChar = '\u2502';
        char floorCeilingChar = '\u2500';
        char dividerChar = '\u2500';
        char doubleDivider = '\u2550';
        char doubleBottomLeft = '\u255A';
        char doubleBottomRight = '\u255D';
        char doubleTopLeft = '\u2554';
        char doubleTopRight = '\u2557';
        char tLeftToRight = '\u251C';
        char doubleTLeftToRight = '\u2560';
        char tRightToLeft = '\u2524';
        char doubleTRightToLeft = '\u2563';
        char escapeChar = '\u2190';
        char doubleWallChar = '\u2551';

        // Create StringBuilder for the menu and add all of the options
        StringBuilder sb = new StringBuilder();
        StringBuilder titleBuilder = new StringBuilder(doubleWallChar + title);

        // Count the longest string
        for(int i = 0; i < options.length; i++){
            String s = (i + 1 + ") " + options[i]);
            if (s.length() + 3 > longest) longest = s.length() + 3;
        }

        // Set title to longest if it is longer than all options
        longest = title.length() + 4 > longest ? title.length() + 4 : longest;
        longest = exitOption.length() + 7 > longest ? exitOption.length() + 7 : longest;

        //  Create menu borders
        String upperBorder = Character.toString(doubleTopLeft);
        String bottomBorder = Character.toString(bottomLeftCornerChar);
        String upperBottomBorder = "";
        String divider = Character.toString(tLeftToRight);
        String titleDivider = Character.toString(doubleTopLeft);
        String titleBottom = Character.toString(doubleTLeftToRight);
        String spacer = Character.toString(wallChar);

        for (int i = 0; i < longest; i++) {
            upperBottomBorder += floorCeilingChar;
            divider += dividerChar;
            titleDivider += doubleDivider;
            titleBottom += doubleDivider;
            spacer += " ";
        }
        upperBorder = titleDivider + doubleTopRight;
        bottomBorder += upperBottomBorder + bottomRightCornerChar;
        divider += tRightToLeft;
        titleDivider += doubleTopRight;
        titleBottom += doubleTRightToLeft;
        spacer += wallChar;

        for (int i = 0; i < options.length; i++) {
            String s = (i + 1 + ") " + options[i]);

            sb.append(wallChar + " " + s);

            if(s.length() != longest + 2){
                for (int x = s.length(); x < longest - 1; x++){
                    sb.append(" ");
                }
                sb.append(wallChar);
            }
            sb.append("\n");
        }

        if(options.length == 0) sb.append(spacer + "\n");
        String exitOptionFull = wallChar + " " + (options.length + 1) + ") " + escapeChar + " " + exitOption;
        sb.append(divider + "\n" + exitOptionFull);
        for (int i = exitOptionFull.length(); i < longest + 1; i++) {
            sb.append(" ");
        }
        sb.append(wallChar + "\n");

        sb.insert(0, "\n");

        // Create Title StringBuilder
        int titleLength = (doubleWallChar + title).length();
        int titleMiddle = (titleLength +1) / 2;
        for (int i = 0; i < (titleDivider.length() / 2) - titleMiddle; i++) {
            titleBuilder.insert(1, " ");
        }

        for(int i = titleBuilder.length(); i < longest + 1; i++){
            titleBuilder.append(" ");
        }
        titleBuilder.append(doubleWallChar);

        // Title Divider
        sb.insert(0, titleBottom);
        sb.insert(0, titleBuilder.toString() + "\n");
        sb.insert(0, upperBorder + "\n");
// Return divider bottom
        sb.append(bottomBorder);
        return "\n" + sb.toString() + "\n";
    }
}
