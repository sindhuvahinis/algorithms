package dynamicprogramming;

/**
 * Input: {1, 2, 3, 4}
 * Output: True
 * Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
 */
public class EqualSubSetSumPartition {

    public boolean canPartition(int[] input) {

        int sum = 0;
        for (int value : input) {
            sum += value;
        }

        if (sum % 2 != 0)
            return false;

        Boolean[][] dp = new Boolean[input.length][(sum/2)+1];


        return canPartition(input, 0, sum/2, dp);
    }

    public boolean canPartition(int[] input, int index, int sum, Boolean[][] dp) {
        if (sum == 0)
            return true;

        if (sum < 0 || index >= input.length)
            return false;

        if (dp[index][sum] != null)
            return dp[index][sum];

        boolean p1 = canPartition(input, index + 1, sum - input[index], dp);
        boolean p2 = canPartition(input, index + 1, sum, dp);

        dp[index][sum] = p1 || p2;

        return dp[index][sum];
    }

    public static void main(String[] args) {

        EqualSubSetSumPartition partition = new EqualSubSetSumPartition();
        System.out.println(partition.canPartition(new int[] {1, 2, 3, 4}));
        System.out.println(partition.canPartition(new int[]{1, 1, 3, 4, 7}));
        System.out.println(partition.canPartition(new int[]{2, 3, 4, 6}));

    }

}
