package com.roushan._19_DynamicProgramming;

public class _07_CoinChangeCountCombinationsRecursion {
    public static void main(String[] args) {
        int[] coins = {2, 5, 3, 6};
        int sum = 10;
        //1st way.
        System.out.println(count(coins, 0, 0, sum));
        //2nd way.
        System.out.println(count1(coins, coins.length, sum));

    }

    //1st way.
    // Recursive method to count combinations
    public static int count(int[] coins, int i, int checkSum, int sum) {
        // Base case: if checkSum equals a sum, a valid combination is found
        if (checkSum == sum) {
            return 1;
        }
        // Base case: if checkSum exceeds sum, no valid combination is possible
        if (checkSum > sum) {
            return 0;
        }
        int res = 0;
        // Iterate over all coins
        for (int j = i; j < coins.length; j++) {
            // Recursively call count with updated checkSum
            res += count(coins, j, checkSum + coins[j], sum);
        }
        return res;
    }

    //2nd way.
    //It is also recursive.
    public static int count1(int[] coins, int n, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int res = count1(coins, n - 1, sum);
        if (coins[n - 1] <= sum) {
            res += count1(coins, n, sum - coins[n - 1]);
        }
        return res;
    }
}
//both take time complexity of O(2^n).
