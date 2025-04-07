import java.util.*;

public class DynamicProgrammingGPT {

    public static void main(String[] args) {
        Things th = new Things();
        int packageSize = 4;
        List<Map<Entity, Object>> things = th.getThings();
        int maxValue = backPack(packageSize, things);
        System.out.println("Max value that can be carried: $" + maxValue);
    }

    /*
      We have packages with volume 1, 2, 3, 4 kg
      Our goal find most expensive things up to/equal to related weight

      Guitar       1kg, $1500
      Tape rec.    4kg, $3000
      Laptop       3kg, $2000
      phone        1kg, $2000

                  1kg   2kg   3kg   4kg
      Guitar       g     g     g     g
      tape rec.    g     g     g     t
      Laptop       g     g     l     lg
      phone        p     pg    pg    pl
     */

    public static int backPack(int packageSize, List<Map<Entity, Object>> things) {

        int n = things.size();
        int[][] dp = new int[n + 1][packageSize + 1];

        for (int i = 1; i <= n; i++) {
            int weight = (int) things.get(i - 1).get(Entity.WEIGHT);
            int price = (int) things.get(i - 1).get(Entity.PRICE);

            for (int w = 1; w <= packageSize; w++) {
                if (weight <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight] + price);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        printSelectedItems(dp, things, packageSize);
        return dp[n][packageSize];
    }

    private static void printSelectedItems(int[][] dp, List<Map<Entity, Object>> things, int capacity) {
        int n = things.size();
        int w = capacity;
        List<String> selectedItems = new ArrayList<>();

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                selectedItems.add((String) things.get(i - 1).get(Entity.NAME));
                w -= (int) things.get(i - 1).get(Entity.WEIGHT);
            }
        }

        Collections.reverse(selectedItems);
        System.out.println("Selected items: " + selectedItems);
    }

    enum Entity{
        NAME,
        WEIGHT,
        PRICE
    }

    static class Things {

        public List<Map<Entity, Object>> getThings() {
            List<Map<Entity, Object>> thingsList = new ArrayList<>();

            Map<Entity, Object> guitar = new HashMap<>();
            guitar.put(Entity.NAME, "guitar");
            guitar.put(Entity.WEIGHT, 1);
            guitar.put(Entity.PRICE, 1500);
            thingsList.add(guitar);

            Map<Entity, Object> tapeRec = new HashMap<>();
            tapeRec.put(Entity.NAME, "tapeRec");
            tapeRec.put(Entity.WEIGHT, 4);
            tapeRec.put(Entity.PRICE, 3000);
            thingsList.add(tapeRec);

            Map<Entity, Object> laptop = new HashMap<>();
            laptop.put(Entity.NAME, "laptop");
            laptop.put(Entity.WEIGHT, 3);
            laptop.put(Entity.PRICE, 2000);
            thingsList.add(laptop);

            Map<Entity, Object> phone = new HashMap<>();
            phone.put(Entity.NAME, "phone");
            phone.put(Entity.WEIGHT, 1);
            phone.put(Entity.PRICE, 2000);
            thingsList.add(phone);

            return thingsList;
        }
    }
}
