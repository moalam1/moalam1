package com.ds.TwoPointer;

class SortedSquares {
    public int[] sortedSquares(int[] nums) {
        
        int[] res = new int[nums.length];
        
        if(nums.length == 0) return res;
        
        int left = 0, right = nums.length - 1;
        
        int k = nums.length - 1;
        
        while(left <= right){
            
            if( (nums[left] * nums[left]) >=   (nums[right] * nums[right]) ){
                 res[k--] = (nums[left] * nums[left]);
                 left ++;
            }else{
                 res[k--] = (nums[right] * nums[right]);
                 right --;
            }
            
        }
        return res;
        
    }
}