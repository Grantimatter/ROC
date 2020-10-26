package formatting;

public final class StringFormatting {
    public static String formatAttribute(String valueName, String value, int indent){

        StringBuilder sb = new StringBuilder(valueName);

        for(int i = valueName.length(); i < indent; i++){
            if(valueName.length() < i){
                sb.insert(0," ");
            }
            else{
                sb.append(" ");
            }
        }

        sb.append(": "+value);

        return sb.toString();
    }

    public static String formatAttributes(String[] valueNames, String[] values, int indent){
        // If no indent is provided, calculate indent based on largest value name
        if(indent == 0){
            for(String s:valueNames){
                if(s.length() >= indent){
                    indent = s.length() + 1;
                }
            }
        }

        // Iterate through array and use existing method to place indents
        String finalString = "";
        for(int i = 0; i < valueNames.length; i++){
            finalString += "\n" + formatAttribute(valueNames[i], values[i], indent);
        }

        return finalString;
    }
}
