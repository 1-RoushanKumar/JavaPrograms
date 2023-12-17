package com.Concept;

public class _61_BitOperFindPowerOfAnyNumber {
    public static void main(String[] args) {
        int base = 3;
        int power = 6;
        int ans = find(base, power);
        System.out.println(base + " to the power of " + power + " is:" + ans);
    }

    //1st method is naive method iterate and give multiplying which take time complexity of O(power).

    //Efficient way Which take only O(logn).
    static int find(int base, int power) {
        int ans = 1;
        while (power != 0) {
            if ((power & 1) == 1) {
                ans = ans * base;
            }
            base = base * base;
            power = power >> 1;
        }
        return ans;
    }
}
//power = 110 after and(&) we find that it is equal to 0
//then base = 3*3=9 and then right shift power by 1.Hence power = 11
//again power & 1 = 1 this time then ans = ans * base = 1 * 9 = 9
//base = base * base = 9*9=81 and then right shift again power = 1
//after power&1=1 then ans = 9 * 81 = 729 just return it.
