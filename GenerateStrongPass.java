import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GenerateStrongPass {

    public static void main(String[] args) {
        String pass = genPass(20);
        System.out.println(pass);
    }

    private static String genPass(int len) {
        StringBuilder pass = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < len/4; i++) {
            int lower = random.nextInt(25) + 97; // a - z. 97 - 122
            int upper = random.nextInt(25) + 65; // A - Z. 65 - 90
            int dig = random.nextInt(9) + 48;    // 0 - 9. 48 - 57
            int spec = specSymbols().get(random.nextInt(specSymbols().size()));

            pass
                    .append((char) lower)
                    .append((char) upper)
                    .append((char) dig)
                    .append((char) spec);
        }
        return pass.toString();
    }

    private static List<Integer> specSymbols() {
        return Arrays
                .asList(33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45,
                        46, 47, 58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94,
                        95, 96, 123, 124, 125, 126);
    }
}
