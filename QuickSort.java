public class QuickSort {

    public static void main(String[] args) {
        Integer[] arr = {45,76,8,67,90,54,45,45,34,67,5,6,8,8,6,55,4,4,5,45,4,34,5,899,80,9,9,87,8};

        // Case #1 [copied]
        quickSort(arr, arr[0], arr[arr.length - 1]);

        // Case #2
        sort(arr);
    }

    public static void quickSort(Integer[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }

    public static int partition(Integer[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    /**
     * Case #2
     * Each iteration checks if array is sorted
     * If not - swap arr[i] with arr[i + 1] in loop
     */
     public static Integer[] sort(Integer[] arr) {

        while (!isSorted(arr)) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] >= arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }
        return arr;
     }

     public static Boolean isSorted(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] > arr[i + 1]) return false;
        return true;
     }

}
