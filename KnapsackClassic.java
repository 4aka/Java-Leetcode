import java.util.*;

public class KnapsackClassic {
    public static void main(String[] args) {
        int[] weights = {1, 4, 3, 1};   // Ваги предметів
        int[] values = {1500, 3000, 2000, 2000}; // Відповідні ціни предметів
        int capacity = 3;  // Максимальна місткість рюкзака

        int maxProfit = knapsack(weights, values, capacity);
        System.out.println("Максимальна вартість, яку можна отримати: $" + maxProfit);
    }

    public static int knapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        printSelectedItems(dp, weights, values, capacity);
        return dp[n][capacity];
    }

    private static void printSelectedItems(int[][] dp, int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int w = capacity;
        List<String> selectedItems = new ArrayList<>();

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add("Предмет " + i + " (вага: " + weights[i - 1] + ", вартість: $" + values[i - 1] + ")");
                w -= weights[i - 1];
            }
        }

        Collections.reverse(selectedItems);
        System.out.println("Обрані предмети: " + selectedItems);
    }
}