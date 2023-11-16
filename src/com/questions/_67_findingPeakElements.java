//ex--> arr[10,80,40,30,20,50,60] in this question peak element is 80.because 80 is greater than its both neighbour elements.
//it will return the first peak element in the array then return.

package com.questions;

public class _67_findingPeakElements {

    static int getPeak(int[] arr, int n) {
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if ((mid == 0 || arr[mid - 1] <= arr[mid]) &&
                    (mid == n - 1 || arr[mid + 1] <= arr[mid]))
                return mid;
            if (mid > 0 && arr[mid - 1] >= arr[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    public static void main(String [] args) {

        int[] arr = {5, 20, 40, 30, 20, 50, 60};
        int n = arr.length - 1;

        System.out.println(getPeak(arr, n));

    }

}
