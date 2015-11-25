package easy.uniqueWordAbbreviation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidWordAbbr {
    private Map<String, Set<String>> dict = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        if(dictionary == null || dictionary.length == 0) {
            return;
        }

        for(int i = 0; i < dictionary.length; i++) {
            String word = dictionary[i];
            if(word == null) {
                continue;
            }

            String abbr = getAbbreviation(word);
            Set<String> wordSet = dict.containsKey(abbr) ? dict.get(abbr) : new HashSet<String>();
            wordSet.add(word);
            dict.put(abbr, wordSet);
        }
    }

    private String getAbbreviation(String word) {
        String abbr = null;
        if(word.length() <= 2) {
            abbr = word;
        }
        else {
            abbr = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
        }
        return abbr;
    }

    public boolean isUnique(String word) {
        if(word == null) {
            return false;
        }

        String abbr = getAbbreviation(word);

        return !dict.containsKey(abbr) || (dict.get(abbr).contains(word) && dict.get(abbr).size() == 1);
    }
}
