public class Recursion {

    // https://www.geeksforgeeks.org/recursion-in-java/

    public static void main(String[] args) {
        // System.out.println(factorial(9));
        int[] ar = new int[]{1,3,5,7,5,3,5,3,7,6,5};
        System.out.println(arraySum(ar, ar.length - 1));
    }

    // Iterations: x, x - 1, x - 2, ..., x - n => 5 4 3 2 1
    // Operations: 5 * 4 * 3 * 2 * 1
    public static int factorial(int x) {
        System.out.println(x);
        if (x == 1) return 1;
        else return x *= factorial(x - 1);
    }

    // int[] ar is a static object and it is not changed
    // int[] ar is like an outer static object
    // int (ar.length - 1) is count down 4 => 3 => 2 => 1 => 0
    public static int arraySum(int[] ar, int l) {
        if (l < 1) return ar[l];
        else return ar[l] + arraySum(ar, l-1);
    }


}
