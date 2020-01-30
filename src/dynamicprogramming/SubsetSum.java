package dynamicprogramming;

/**
 * {1, 2, 3, 7},
 * Sum = 6
 */
public class SubsetSum {

    public boolean doesSumExist(int[] input, int sum) {
        Boolean dp[][] = new Boolean[input.length][sum+1];
        return doesSumExist(input, sum, 0, dp);
    }

    public boolean doesSumExist(int[] input, int sum, int currentIndex, Boolean[][] dp) {
        if (currentIndex >= input.length || sum < 0)
            return false;

        if (sum == 0)
            return true;

        if (dp[currentIndex][sum] != null)
            return dp[currentIndex][sum];

        boolean p1 = doesSumExist(input, sum - input[currentIndex], currentIndex + 1, dp);
        boolean p2 = doesSumExist(input, sum, currentIndex + 1, dp);

        dp[currentIndex][sum] = p1 || p2;

        return dp[currentIndex][sum];
    }

    public static void main(String[] args) {
        System.out.println(new SubsetSum().doesSumExist(new int[]{1,2,3,7}, 6));
    }
}
