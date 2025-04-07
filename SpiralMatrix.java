import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        List<int[]> lst = new ArrayList<>();
        lst.add(new int[]{ 1,  2,  3,  4 });
        lst.add(new int[]{ 5,  6,  7,  8 });
        lst.add(new int[]{ 9,  10, 11, 12 });
        lst.add(new int[]{ 13, 14, 15, 16 });

        System.out.println("[1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]");
        System.out.println(Arrays.toString(getSpiralMatrixGPT(lst)));
        System.out.println(Arrays.toString(getSpiralMatrix(lst)));
    }

    public static int[] getSpiralMatrix(List<int[]> lst) {
        int[] result = new int[lst.size() * lst.get(0).length];
        int elLength = lst.get(0).length, idx = 0;

        while (idx < result.length) {
            // horizontal line = 1 2 3 4
            for (int i = 0; i < elLength; i++) {
                if (lst.get(0)[i] != -1) result[idx++] = lst.get(0)[i]; }
            lst.remove(0); // control

            // last indexes = 8 12
            for (int i = 0; i < lst.size() - 1; i++) {
                if (lst.get(i)[elLength - 1] != -1) {
                    result[elLength + i] = lst.get(i)[elLength - 1];
                    lst.get(i)[elLength - 1] = -1;} // control
                idx++; }

            // revert last list's element = 16 15 14 13
            for (int i = elLength - 1; i >= 0; i--) {
                if (lst.get(lst.size() - 1)[i] != -1) result[idx++] = lst.get(lst.size() - 1)[i]; }
            lst.remove(lst.size() - 1); // control

            // first indexes = 9 5
            for (int i = 0; i < lst.size() - 1; i++) {
                if (lst.get(lst.size() - 1)[i] != -1) {
                    result[idx++ + i] = lst.get(lst.size() - 1)[i];
                    lst.get(lst.size() - 1)[i] = -1;}} // control
        }
        return result;
    }

    public static int[] getSpiralMatrixGPT(List<int[]> lst) {
        int[] result = new int[lst.size() * lst.get(0).length];
        int top = 0, bottom = lst.size() - 1, left = 0, right = lst.get(0).length - 1;
        int idx = 0;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) result[idx++] = lst.get(top)[i]; // top
            top++;

            for (int i = top; i <= bottom; i++) result[idx++] = lst.get(i)[right]; // right row
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) result[idx++] = lst.get(bottom)[i]; // bottom
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) result[idx++] = lst.get(i)[left]; // left row
                left++;
            }
        }
        return result;
    }
}
