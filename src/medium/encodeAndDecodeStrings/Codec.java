package medium.encodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if(strs == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for(String str : strs) {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        if(s == null) {
            return null;
        }

        List<String> result = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int divideIndex = s.indexOf("#", i);
            int size = Integer.parseInt(s.substring(i, divideIndex));
            result.add(s.substring(divideIndex + 1, divideIndex + 1 + size));
            i = divideIndex + 1 + size;
        }

        return result;
    }
}
