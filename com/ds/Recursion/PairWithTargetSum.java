package com.ds.TwoPointer;
/*
* Pair with Target Sum (easy)
* Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
*/
class PairWithTargetSum {

  public static int[] search(int[] arr, int targetSum) {
    // TODO: Write your code here

    int[] res = new int[] { -1, -1 };
    int left = 0;
    int right = arr.length - 1;

    while(left < right){

      int sum  = arr[left] + arr[right];

      if(sum == targetSum){
         res[0] = left;
         res[1] = right;
         return res;
      }else if(sum < targetSum){
          left++;
      }else{
        right--;
      }

    }
    return res;
  }
}