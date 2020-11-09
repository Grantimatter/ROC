public class StringFormatMain {

    private static final char TOP_LEFT_CORNER_CHAR = '\u250C';
    private static char TOP_RIGHT_CORNER_CHAR = '\u2510';
    private static char bottomLeftCornerChar = '\u2514';
    private static char bottomRightCornerChar = '\u2518';
    private static char wallChar = '\u2502';
    private static char floorCeilingChar = '\u2500';
    private static char DIVIDER_CHAR = '\u2500';
    private static char doubleDivider = '\u2550';
    private static char doubleBottomLeft = '\u255A';
    private static char doubleBottomRight = '\u255D';
    private static char doubleTopLeft = '\u2554';
    private static char doubleTopRight = '\u2557';
    private static char tLeftToRight = '\u251C';
    private static char doubleTLeftToRight = '\u2560';
    private static char tRightToLeft = '\u2524';
    private static char doubleTRightToLeft = '\u2563';
    private static char escapeChar = '\u2190';
    private static char doubleWallChar = '\u2551';

    public static void main(String[] args) {
        String title = "Are you with me abigailllllllllposapodfjoipjiohag4564897987j";
        int width = title.length() + 6;
        int titlePadding = (width - title.length()) / 2;

        String topBorder = String.format("%c%"+width+"c%n",TOP_LEFT_CORNER_CHAR, TOP_RIGHT_CORNER_CHAR).replace(' ', DIVIDER_CHAR);
        String titleFormatted = String.format("%c%"+(title.length() + titlePadding)+"s%"+titlePadding+"c%n", wallChar, title, wallChar);

        System.out.print(topBorder);
        System.out.print(titleFormatted);
    }
}
