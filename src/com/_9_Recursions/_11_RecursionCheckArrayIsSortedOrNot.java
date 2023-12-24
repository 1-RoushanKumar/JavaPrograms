package com._9_Recursions;

public class _11_RecursionCheckArrayIsSortedOrNot {
    public static void main(String[] args) {
        int[] arr = {1, 2, 30, 8, 9, 12};
        boolean flag = check(arr, 0);
        System.out.println(flag);
    }

    static boolean check(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        } else {
            return (arr[i] < arr[i + 1]) && check(arr, i + 1);    //we can use and conditional operator in return statement also.
        }
    }
}
//for detail debug it.
//ex={1,2,4,8} Now, arr.length=4 Base condition is if(i==4-1) then return true.
//initially i = 0;
//check(i==3) -> No then (arr[0]<arr[1]) && check(arr,1)
//----------------------------------------> (arr[1]<arr[2]) && check(arr,2)
//-----------------------------------------------------------> (arr[2]<arr[3]) && check(arr,3)
//when it reached check(arr,3) then i=3 which satisfy the condition (i==arr.length-1).Hence it will return true
//to then check(arr,3) and it keep repeating it to check(arr,2) then check(arr,1) then to main and exit.
//It will return true only when both condition (arr[i] < arr[i+1]) && check(arr,i+1) are true.
