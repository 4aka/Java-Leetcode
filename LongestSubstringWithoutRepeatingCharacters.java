public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        lengthOfLongestSubstring("bbbbbbbb");       // 1
        lengthOfLongestSubstring("pwwkew");         // 3
        lengthOfLongestSubstring("ckilbkd");        // 5
        lengthOfLongestSubstring("dvdf");           // 3
        lengthOfLongestSubstring("abcabcbb");       // 3
        lengthOfLongestSubstring("abcb");           // 3
        lengthOfLongestSubstring("anviaj");         // 5
        lengthOfLongestSubstring("nfpdmpi");        // 5
        lengthOfLongestSubstring("aabaab!bb");      // 3
        lengthOfLongestSubstring("hkcpmprxxxqw");   // 5
    }

    public static int lengthOfLongestSubstring(String s) {
        String sub;
        StringBuilder result = new StringBuilder();
        int tmp = 0;

        for (int i = 0; i < s.length(); i++) {
            sub = s.substring(i, i + 1);

            if (result.toString().contains(sub)) {
                if (i + 2 <= s.length()) {
                    tmp = Math.max(tmp, result.length());
                    result.delete(0, result.indexOf(sub) + 1).append(sub);
                }
            } else {
                result.append(sub);
            }
        }
        return Math.max(tmp, result.length());
    }
}
