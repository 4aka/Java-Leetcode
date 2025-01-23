import java.util.*;
import java.util.stream.Collectors;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String res = longestCommonPrefix( new String[]
                {"find", "carmen", "flower", "flow", "flight"} );
        System.out.println(res);
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = ""; String tmp = "";

        // Data preparation
        List<String> sortedWords = Arrays.stream(strs).sorted().collect(Collectors.toList());
        Map<Character, List<String>> groupedMap = new TreeMap<>();

        for (String word : sortedWords) {
            char startLetter = word.charAt(0);
            groupedMap.putIfAbsent(startLetter, new ArrayList<>());
            groupedMap.get(startLetter).add(word);
        }
        List<List<String>> data = new ArrayList<>(groupedMap.values());

        for (List<String> words : data) {

            // Find prefix length of the shortest word
            int maxWordLen = words.stream().mapToInt(String::length).max().getAsInt();
            String maxWord = words.stream().filter(w -> w.length() == maxWordLen)
                    .collect(Collectors.toList()).get(0);

            // Algorithm
            for (String word : words) {
                String tmpWord = maxWord;
                for (int i = maxWord.length() - 1; i > 0; i--) {
                    if (word.startsWith(tmpWord) && !word.equals(maxWord)) { tmp = tmpWord; }
                    else { tmpWord = tmpWord.substring(0, i); }
                }
            }

            // Compare prefixes
            if (tmp.length() > prefix.length()) {
                prefix = tmp;
            }
        }
        return prefix;
    }
}
