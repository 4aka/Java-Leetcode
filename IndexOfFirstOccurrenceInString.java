public class IndexOfFirstOccurrenceInString {

    public static void main(String[] args) {
        System.out.println(strStr("butsad", "sad"));
    }

    public static int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) return -1;

        else {
            char[] haystackCharArray = haystack.toCharArray();
            char firstLetter = needle.toCharArray()[0];

            for (int i = 0; i < haystack.length(); i++) {

                if (haystackCharArray[i] == firstLetter) {
                    if (haystack.substring(i).startsWith(needle)) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}
