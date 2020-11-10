package com.grantwiswell.banking.util.menu;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MenuFormatting {

    private static final char TOP_LEFT_CORNER_CHAR = '\u250C';
    private static final char LIGHT_CROSS = '\u253C';
    private static final char TOP_RIGHT_CORNER_CHAR = '\u2510';
    private static final char BOTTOM_LEFT_CORNER_CHAR = '\u2514';
    private static final char BOTTOM_RIGHT_CORNER_CHAR = '\u2518';
    private static final char WALL_CHAR = '\u2502';
    private static final char FLOOR_CEILING_CHAR = '\u2500';
    private static final char DIVIDER_CHAR = '\u2500';
    private static final char DOUBLE_DIVIDER_CHAR = '\u2550';
    private static final char DOUBLE_BOTTOM_LEFT_CORNER_CHAR = '\u255A';
    private static final char DOUBLE_BOTTOM_RIGHT_CORNER_CHAR = '\u255D';
    private static final char DOUBLE_TOP_LEFT_CORNER_CHAR = '\u2554';
    private static final char DOUBLE_TOP_RIGHT_CORNER_CHAR = '\u2557';
    private static final char T_LEFT_TO_RIGHT = '\u251C';
    private static final char DOUBLE_T_LEFT_TO_RIGHT = '\u2560';
    private static final char T_RIGHT_TO_LEFT = '\u2524';
    private static final char DOUBLE_T_RIGHT_TO_LEFT = '\u2563';
    private static final char RETURN_CHAR = '\u2190';
    private static final char DOUBLE_WALL_CHAR = '\u2551';

    private static Logger log = Logger.getLogger(MenuFormatting.class);

    public static String createOptionsMenu(String title, String exitOption, boolean hasRowDividers, String... options) {
        // Define the width of the menu based on the longest string;
        int width = 0;
        int maxCellCount = 1;
        List<String[]> optionCells = new ArrayList<>();
        for (String s : options) {
            if (s.length() > width) width = s.length();

            // Count the number of cells represented in the list of options
            String[] cellArray = s.split(Pattern.quote("\u2502"));
            if (cellArray != null && cellArray.length > 0) {
                if (cellArray.length > maxCellCount) maxCellCount = cellArray.length;
                optionCells.add(cellArray);
            }
        }

        if (maxCellCount > 1) {
            options = formatCells(optionCells, maxCellCount, false);
            for (String s : options) {
                if (s.length() / 2 > width) width = (s.length() / 2) - 5;
            }
        }
        if (title.length() > width) width = title.length();
        if (exitOption.length() > width) width = exitOption.length();
        width += 7;

        String topBorder = String.format("%c%" + width + "c%n", DOUBLE_TOP_LEFT_CORNER_CHAR, DOUBLE_TOP_RIGHT_CORNER_CHAR).replace(' ', DOUBLE_DIVIDER_CHAR);
        String titleFormatted = DOUBLE_WALL_CHAR + centerString(title, width, ' ') + " " + DOUBLE_WALL_CHAR + "\n";
        String titleDivider = String.format("%c%" + width + "c%n", DOUBLE_T_LEFT_TO_RIGHT, DOUBLE_T_RIGHT_TO_LEFT).replace(' ', DOUBLE_DIVIDER_CHAR);
        String divider = String.format("%c%" + width + "c%n", T_LEFT_TO_RIGHT, T_RIGHT_TO_LEFT).replace(' ', DIVIDER_CHAR);
        String bottomBorder = String.format("%c%" + width + "c%n", BOTTOM_LEFT_CORNER_CHAR, BOTTOM_RIGHT_CORNER_CHAR).replace(' ', DIVIDER_CHAR);

        StringBuilder stringBuilder = new StringBuilder(topBorder + titleFormatted + titleDivider);
        for (int i = 0; i < options.length; i++) {
            stringBuilder.append(WALL_CHAR + " " + leftAlignString((i + 1) + ") " + options[i], width, ' '));
            if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ') stringBuilder.append(WALL_CHAR + "\n");
            else stringBuilder.append("\n");
            if (hasRowDividers && i < options.length - 1) {
                stringBuilder.append(divider);
            }
        }
        stringBuilder.append(divider);
        stringBuilder.append(WALL_CHAR + " " + leftAlignString(String.format("%d) %c %s", options.length + 1, RETURN_CHAR, exitOption), width, ' ') + "\u2502\n");
        stringBuilder.append(bottomBorder);

        return stringBuilder.toString();
    }

    public static String[] formatCells(List<String[]> options, int maxCellCount, boolean centered) {
        // Get the amount of cells that will be represented
        String[] formattedCells = new String[options.size()];

        // Get the maximum width of each cell
        int[] cellLengths = new int[maxCellCount];
        for (int x = 0; x < options.size(); x++) {
            for (int y = 0; y < maxCellCount; y++) {
                if (options.get(x).length >= maxCellCount && options.get(x)[y].length() > cellLengths[y]) {
                    cellLengths[y] = options.get(x)[y].length() + 3;
                }
            }
        }

        // Go through every cell and make sure that it is the new maximum width
        for (int x = 0; x < options.size(); x++) {
            int rowDigitsDifference = (Integer.toString(options.size()).length() - Integer.toString(x + 1).length());
            log.info("Row " + x + " digits in row#: " + rowDigitsDifference);
            String option = String.format("%" + (rowDigitsDifference > 0 ? (rowDigitsDifference + 1) + "c" : "c"), WALL_CHAR);
            String optionDivider = String.format("%n%c%" + (4 + Integer.toString(options.size()).length()) + "c", T_LEFT_TO_RIGHT, LIGHT_CROSS);
            for (int y = 0; y < maxCellCount; y++) {
                int cellLength = cellLengths[y];
                if (options.get(x).length >= maxCellCount && options.get(x)[y].length() <= cellLengths[y]) {
                    if (centered)
                        option += centerString(options.get(x)[y], (cellLength + 1), ' ');
                    else
                        option += leftAlignString(options.get(x)[y], (cellLength + 1), ' ');
                } else {
                    option += String.format("%" + (cellLength + 1) + "s", " ");
                    optionDivider += String.format("%" + (cellLength) + "c", ' ');
                }
                if (y < maxCellCount - 1) optionDivider += String.format("%" + (cellLength) + "c", LIGHT_CROSS);
                else if (y == maxCellCount - 1)
                    optionDivider += String.format("%" + (cellLength) + "c", T_RIGHT_TO_LEFT);
                option += WALL_CHAR;
            }
            formattedCells[x] = option + optionDivider.replace(' ', DIVIDER_CHAR);
        }
        return formattedCells;
    }

    public static String centerString(String str, int width, char divider) {
        int padding = (width - str.length()) / 2;
        String formatted = String.format("%c%" + (padding + str.length() - 1) + "s", ' ', str);
        return endPadString(formatted, width, divider);
    }

    public static String leftAlignString(String str, int width, char divider) {
        StringBuilder sb = new StringBuilder(str);
        return endPadString(sb.toString(), width, divider);
    }

    public static String endPadString(String str, int width, char divider) {
        int widthLeft = (width - str.length()) + 1;
        if (widthLeft > 3) {
            str += String.format("%" + (widthLeft - 3) + "c", ' ');
        }
        return str.replace(' ', divider);
    }
}
