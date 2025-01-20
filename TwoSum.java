import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static final int[] unsortedFinalArray = {4,15,16,17,18,19,20,21,22,23,24,25,26,27,28};
    static final int[] unsortedArray = {4,15,16,17,18,3,19,20,21,22,23,24,25,7,26,27,28};

    public static void main(String[] args) {
        int[] v1 = twoSumV1(unsortedFinalArray, 48);
        int[] v2 = twoSumV2(unsortedArray, 40);
        System.out.println(Arrays.toString(v1));
        System.out.println(Arrays.toString(v2));
    }

    public static int[] twoSumV1(int[] nums, int target) {
        int[] indices = new int[2];
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == target) {
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    // For the unique array
    public static int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> indicesMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {indicesMap.put(nums[i], i);}

        int[] indices = new int[2];
        int[] sorted = Arrays.stream(nums).sorted().toArray();
        int len = sorted.length;

        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (sorted[i] + sorted[j] == target) {
                    indices[0] = indicesMap.get(sorted[i]);
                    indices[1] = indicesMap.get(sorted[j]);
                    return indices;
                }
            }
        }
        return indices;
    }
}
