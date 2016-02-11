package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSubset {
    public List<String> subset(String word) {
        List<String> results = new ArrayList<>();
        if(word == null || word.length() == 0) {
            results.add("");
            return results;
        }

        char[] wordChars = word.toCharArray();
        // sort wordChars
        Arrays.sort(wordChars);
        backtracking(wordChars, 0, new ArrayList<Character>(), results);

        return results;
    }

    private void backtracking(char[] wordChars, int step, List<Character> path, List<String> results) {
        StringBuilder sb = new StringBuilder();
        for(char c : path) {
            sb.append(c);
        }
        results.add(sb.toString());

        for(int i = step; i < wordChars.length; i++) {
            // skip duplication
            if(i != step && wordChars[i] == wordChars[i - 1]) {
                continue;
            }

            path.add(wordChars[i]);
            backtracking(wordChars, i + 1, path, results);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        String joe = "joseph";
        StringSubset subset = new StringSubset();
        System.out.println(subset.subset(joe).size());
    }
}
