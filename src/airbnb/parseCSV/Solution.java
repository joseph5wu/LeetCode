package airbnb.parseCSV;

public class Solution {
    private static String parseCSV(String str) {
        StringBuilder result = new StringBuilder();
        StringBuilder part = new StringBuilder();
        boolean inQuote = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (inQuote) {
                if (c == '\"') {
                    if (i == str.length() - 1) {
                        break;
                    } else if (str.charAt(i + 1) == '\"') {
                        part.append('\"');
                        i++;
                    } else {
                        inQuote = false;
                    }
                } else {
                    part.append(c);
                }
            } else {
                if (c == '\"') {
                    inQuote = true;
                } else if (c == ',') {
                    part.append('|');
                    result.append(part.toString());
                    part = new StringBuilder();
                } else {
                    part.append(c);
                }
            }
        }

        return result.append(part.toString()).toString();
    }

    public static void main(String[] args) {
        //#1
        System.out.println(parseCSV("John,Smith,john.smith@gmail.com,Los Angeles,1"));
        //#2
        System.out.println(parseCSV("Jane,Roberts,janer@msn.com,\"San Francisco, CA\",0"));
        System.out.println(parseCSV("\"Alexandra \"\"Alex\"\"\",Menendez,alex.menendez@gmail.com,Miami,1"));
    }
}
