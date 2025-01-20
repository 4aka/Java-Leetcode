public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(7299957));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(3));
        System.out.println(isPalindrome(5436435));
    }

    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int counter1 = 0;
        int counter2 = chars.length - 1;
        while (counter1 < chars.length/2) {
            if (chars[counter1] != chars[counter2]) {
                return false;
            } else {
                counter1++;
                counter2--;
            }
        }
        return true;
    }
}
