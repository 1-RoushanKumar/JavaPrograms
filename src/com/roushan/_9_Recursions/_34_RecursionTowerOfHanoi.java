package com.roushan._9_Recursions;

public class _34_RecursionTowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        int ans = TOH(n,"From" ,"To", "Aux");
        System.out.println(ans);
    }

    private static int TOH(int n, String From, String To, String Aux) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from rode " + From + " to rode " + To);
            return 1;
        }
        int count = TOH(n - 1, From, Aux, To);
        System.out.println("Move disk " + n + " from rode " + From + " to rode " + To);
        count++;
        count += TOH(n - 1, Aux, To, From);
        return count;
    }
}
