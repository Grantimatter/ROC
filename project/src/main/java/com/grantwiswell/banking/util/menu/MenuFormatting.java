package com.grantwiswell.banking.util.menu;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class MenuFormatting {

    private static final char TOP_LEFT_CORNER_CHAR = '\u250C';
    private static char TOP_RIGHT_CORNER_CHAR = '\u2510';
    private static char BOTTOM_LEFT_CORNER_CHAR = '\u2514';
    private static char BOTTOM_RIGHT_CORNER_CHAR = '\u2518';
    private static char WALL_CHAR = '\u2502';
    private static char FLOOR_CEILING_CHAR = '\u2500';
    private static char DIVIDER_CHAR = '\u2500';
    private static char DOUBLE_DIVIDER_CHAR = '\u2550';
    private static char DOUBLE_BOTTOM_LEFT_CORNER_CHAR = '\u255A';
    private static char DOUBLE_BOTTOM_RIGHT_CORNER_CHAR = '\u255D';
    private static char DOUBLE_TOP_LEFT_CORNER_CHAR = '\u2554';
    private static char DOUBLE_TOP_RIGHT_CORNER_CHAR = '\u2557';
    private static char T_LEFT_TO_RIGHT = '\u251C';
    private static char DOUBLE_T_LEFT_TO_RIGHT = '\u2560';
    private static char T_RIGHT_TO_LEFT = '\u2524';
    private static char DOUBLE_T_RIGHT_TO_LEFT = '\u2563';
    private static char RETURN_CHAR = '\u2190';
    private static char DOUBLE_WALL_CHAR = '\u2551';

    public static String createOptionsMenu(String title, String exitOption, String... options) {
        // Define the width of the menu based on the longest string;
        int width = 0;
        for (String s : options) {
            if (s.length() > width) width = s.length();
        }
        if (title.length() > width) width = title.length();
        if (exitOption.length() > width) width = exitOption.length();
        width += 7;

        String topBorder = String.format("%c%" + width + "c%n", DOUBLE_TOP_LEFT_CORNER_CHAR, DOUBLE_TOP_RIGHT_CORNER_CHAR).replace(' ', DOUBLE_DIVIDER_CHAR);
        String titleFormatted = centerString(title, width, DOUBLE_WALL_CHAR, ' ');
        String titleDivider = String.format("%c%" + width + "c%n", DOUBLE_T_LEFT_TO_RIGHT, DOUBLE_T_RIGHT_TO_LEFT).replace(' ', DOUBLE_DIVIDER_CHAR);
        String divider = String.format("%c%" + width + "c%n", T_LEFT_TO_RIGHT, T_RIGHT_TO_LEFT).replace(' ', DIVIDER_CHAR);
        String bottomBorder = String.format("%c%" + width + "c%n", BOTTOM_LEFT_CORNER_CHAR, BOTTOM_RIGHT_CORNER_CHAR).replace(' ', DIVIDER_CHAR);

        StringBuilder stringBuilder = new StringBuilder(topBorder + titleFormatted + titleDivider);
        for (int i = 0; i < options.length; i++) {
            stringBuilder.append(leftAlignString((i + 1) + ") "+options[i], width, WALL_CHAR, ' '));
        }
        stringBuilder.append(divider);
        stringBuilder.append(leftAlignString(String.format("%d) %c%s", options.length + 1, RETURN_CHAR, exitOption),width, WALL_CHAR, ' '));
        stringBuilder.append(bottomBorder);

        return stringBuilder.toString();
    }

    public static String centerString(String str, int width, char wall, char divider){
        int padding = (width - str.length()) / 2;
        String formatted = String.format("%c%"+(padding + str.length())+"s", wall, str);
        return endPadString(formatted, width, wall, divider).replace(' ', divider);
    }

    public static String leftAlignString(String str, int width, char wall, char divider){
        StringBuilder sb = new StringBuilder(str);
        sb.insert(0,wall + " ");
        int widthLeft = width - sb.length() + 1;
        return String.format("%s%"+widthLeft+"c%n", sb.toString(), wall).replace(' ', divider);
    }

    public static String endPadString(String str, int width, char wall, char divider) {
        int widthLeft = (width - str.length()) + 1;
        str += String.format("%" + widthLeft + "c%n", wall);
        return str.replace(' ', divider);
    }
}
