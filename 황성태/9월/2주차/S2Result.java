package programmers_hst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class S2Result {

    /*
     * Complete the 'countSimilarPairs' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static long countSimilarPairs(List<String> words) {
        Map<String, Integer> countMap = new HashMap<>();
        long similarPairs = 0;

        for (String word : words) {
            String charSet = getCharSet(word);

            int count = countMap.getOrDefault(charSet, 0);
            similarPairs += count;

            countMap.put(charSet, count + 1);
        }

        return similarPairs;
    }

    private static String getCharSet(String word) {
        boolean[] charSet = new boolean[26];
        for (char c : word.toCharArray()) {
            charSet[c - 'a'] = true;
        }

        StringBuilder uniqueChars = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (charSet[i]) {
                uniqueChars.append((char) (i + 'a'));
            }
        }

        return uniqueChars.toString();
    }

}
