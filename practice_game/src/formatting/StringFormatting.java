package formatting;

public final class StringFormatting {

    public static String formatAttribute(String valueName, String value, int indent) {
        return formatAttribute(valueName, value, indent, false);
    }

    public static String formatAttribute(String valueName, String value, int indent, boolean alignRight) {

        StringBuilder sb = new StringBuilder(valueName);

        for (int i = valueName.length(); i < indent; i++) {
            if (alignRight) {
                if (valueName.length() < i) {
                    sb.insert(0, " ");
                } else {
                    sb.append(" ");
                }
            } else {
                sb.append(" ");
            }
        }

        sb.append(": " + value);

        return sb.toString();
    }

    public static String formatAttributes(String[] valueNames, String[] values, int indent) {
        return formatAttributes(valueNames, values, indent, false);
    }

    public static String formatAttributesInline(String title, String[] valueNames, String[] values, String divider) {
        if (valueNames.length != values.length) return null;
        int length = 0;
        String finalString = "";
        for (int i = 0; i < valueNames.length; i++) {
            length += valueNames[i].length() + values[i].length() + divider.length() + 4;
            finalString += divider + " " + valueNames[i] + " : " + values[i] + " ";
            if(i == valueNames.length - 1) finalString += divider;
        }

        // Insert the title if there is one
        if(title != null && title.length() > 0){
            StringBuilder sb = new StringBuilder(finalString);
            String titleString = "| " + title + " |";
            sb.insert(0, titleString+"\n");

            for (int i = 0; i < length / 2 - (titleString.length() / 2); i++) {
                sb.insert(0, " ");
            }

            finalString = sb.toString();
        }

        return finalString;
    }

    public static String formatAttributes(String[] valueNames, String[] values, int indent, boolean alignRight) {
        // If no indent is provided, calculate indent based on largest value name
        boolean hasTitle = valueNames.length > values.length;


        if (indent == 0) {
            int i = 0;
            for (String s : valueNames) {
                if (s.length() >= indent && i >= (hasTitle ? 1 : 0)) {
                    indent = s.length() + 1;
                }
                i++;
            }
        }

        // Iterate through array and use existing method to place indents
        String finalString = "";

        // Format the title of a screen correctly in the center
        if (hasTitle) {
            StringBuilder sb = new StringBuilder(valueNames[0]).insert(0, "| ").append(" |");
            for (int i = 0; i < indent - (valueNames[0].length() / 2); i++) {
                sb.insert(0, " ");
            }
            finalString = sb.toString();
        }

        for (int i = 0; i < valueNames.length - (hasTitle ? 1 : 0); i++) {
            finalString += "\n" + formatAttribute(valueNames[i + (hasTitle ? 1 : 0)], values[i], indent, (alignRight));
        }

        return finalString;
    }

    public static String capEveryWord(String str) {
        String[] cap = str.split(" ");
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < cap.length; i++) {
            sb.append(Character.toUpperCase(cap[i].charAt(0))).append(cap[i].substring(1)).append(" ");
        }

        return sb.toString().trim();
    }
}
