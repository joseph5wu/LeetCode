package hard.textJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> results = new ArrayList<>();
        if(words == null || words.length == 0) {
            return results;
        }

        int index = 0;
        while(index < words.length) {
            int width = words[index].length();
            int last = index + 1;
            // find available words for current line
            while(last < words.length) {
                if(words[last].length() + width + 1 > maxWidth) {
                    break;
                }
                width += words[last].length() + 1;
                last++;
            }

            // adjust space between words
            StringBuilder sb = new StringBuilder();
            int spaceCount = last - index - 1;
            // last line or single word line, left-justified
            if(last == words.length || spaceCount == 0) {
                for(int i = index; i < last; i++) {
                    sb.append(words[i]).append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                for(int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            }
            else {
                int leastSpaceCount = (maxWidth - width) / spaceCount;
                int justifiedSpaceCount = (maxWidth - width) % spaceCount;
                for(int i = index; i < last; i++) {
                    sb.append(words[i]);
                    if(i < last - 1) {
                        for(int j = 0; j <= leastSpaceCount + (i < (index + justifiedSpaceCount) ? 1 : 0); j++) {
                            sb.append(" ");
                        }
                    }
                }
            }

            results.add(sb.toString());
            index = last;
        }
        return results;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a","b","c","d","e"};
        Solution sol = new Solution();
        sol.fullJustify(words, 1);
    }
}
