import java.util.Arrays;
import java.util.List;

public class Roman {

    public static final List<String> combinations = Arrays.asList("IV", "IX", "XL", "XC", "CD", "CM");

    public static void main(String[] args) {
        System.out.println("result: " + romanToInt("MCMXCIV")); // => 1994
        System.out.println("result: " + romanToInt("III"));     // => 3
        System.out.println("result: " + romanToInt("LVIII"));   // => 58
    }

    public static int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();

        for (int i = s.length() - 1; i >= 0; i--) {
            String subString = constructSubString(chars, i);

            if (combinations.contains(subString)) {
                switch (subString) {
                    case "IV": result += 4; break;
                    case "IX": result += 9; break;
                    case "XL": result += 40; break;
                    case "XC": result += 90; break;
                    case "CD": result += 400; break;
                    case "CM": result += 900; break;
                }
                if(i >= 1) { i--; } // skip previous char

            } else {
                switch (chars[i]) {
                    case 'I': result += 1; break;
                    case 'V': result += 5; break;
                    case 'X': result += 10; break;
                    case 'L': result += 50; break;
                    case 'C': result += 100; break;
                    case 'D': result += 500; break;
                    case 'M': result += 1000; break;
                }
            }
        }
        return result;
    }

    // Extracted method to construct substring
    // if (i == 0) {st = "" + chars[i];}
    // else {st = chars[i - 1] + "" + chars[i];}
    private static String constructSubString(char[] chars, int index) {
        return index == 0
                ? Character.toString(chars[index])
                : Character.toString(chars[index - 1]) + chars[index];
    }
}

