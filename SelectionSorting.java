import java.util.*;

public class SelectionSorting {

    public static void main(String[] args) {
        LinkedList<Integer> linkedToSort = new LinkedList<>(Arrays.asList(
                45, 3, 34, 56, 2, 4, 32, 5, 56, 678, 98, 5, 4, 2, 67, 87, 56, 45, 3, 4, 78, 45, 56, 67, 45));
        System.out.println(Arrays.toString(selectionSorting(linkedToSort)));
    }

    public static int[] selectionSorting(LinkedList<Integer> toSort) {
        int len = toSort.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) result[i] = getSmallestNumberAndRemoveIt(toSort);
        return result;
    }

    public static int getSmallestNumberAndRemoveIt(LinkedList<Integer> sort) {
        int result = sort.get(0); int idx = 0;

        for (int i = 0; i < sort.size(); i++) {
            if (sort.get(i) <= result) {
                result = sort.get(i);
                idx = i;
            }
        }
        sort.remove(idx);
        return result;
    }
}
