public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,4,5,6}, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result = i;
                return result;
            } else if (target < nums[i]) {
                result = i;
                return result;
            } else {
                result = nums.length;
            }
        }
        return result;
    }
}
