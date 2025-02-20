import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> ex = new ArrayList<>();
        for (int i = 0; i < 100; i++) ex.add(i);

        System.out.println(findNumber(34, ex));
    }

    public static int findNumber(int find, List<Integer> list) {
        int result = 0;
        int begin = 0, end = list.size() - 1;
        Collections.sort(list);
        if (!list.contains(find)) return 0;

        while (begin <= end) {
            int middleIdx = (end + begin)/2;

            if (find > list.get(middleIdx)) begin = middleIdx;
            else end = middleIdx;

            if (find == list.get(middleIdx)) {
                result = list.get(middleIdx);
                break;
            }
        }
        return result;
    }
}
