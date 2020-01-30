package dynamicprogramming;


import java.util.Arrays;

/**
 * 01 KnapSack problem.
 *
 * Example
 *
 * Items: { Apple, Orange, Banana, Melon }
 * Weights: { 2, 3, 1, 4 }
 * Profits: { 4, 5, 3, 7 }
 * Knapsack capacity: 5
 *
 * Get the maximum profit.
 */
public class KnapSack {

    public int getMaxProfit(int[] weights, int[] profits, int capacity) {
        int[][] dp = new int[weights.length][capacity+1];

        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], -1);

        return getMaxProfit(weights, profits, capacity, 0, dp);
    }

    private int getMaxProfit(int[] weights, int[] profits, int capacity, int currentIndex, int[][] dp) {
        if (currentIndex >= weights.length || capacity <= 0)
            return 0;

        if (dp[currentIndex][capacity] != -1)
            return dp[currentIndex][capacity];

        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + getMaxProfit(weights, profits, capacity - weights[currentIndex], currentIndex+1, dp);

        int profit2 = getMaxProfit(weights, profits, capacity, currentIndex + 1, dp);

        dp[currentIndex][capacity] = Math.max(profit1, profit2);

        return dp[currentIndex][capacity];
    }

    public static void main(String[] args) {
        KnapSack knapSack = new KnapSack();
        int maxProfit = knapSack.getMaxProfit(new int[]{2,3,1,4},new int[]{4,5,3,7},5);
        System.out.println(maxProfit);
    }

}
