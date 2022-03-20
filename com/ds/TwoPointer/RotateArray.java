package com.ds.TwoPointer;
class RotateArray {
    public void rotate(int[] nums, int k) {
        
        if(nums.length == 0) return;
        
        
        int left = 0;
        int right = nums.length - 1;
        
        k = (k >= nums.length) ? k % nums.length : k;
        reverse(nums, 0, nums.length - 1);
       reverse(nums, 0, k-1);
       reverse(nums, k, nums.length - 1);
        
    }
    
    public void swap(int[] nums, int left, int right){
        
        int val = nums[left];
        nums[left] = nums[right];
        nums[right] = val;
        
    }
    
    public void reverse(int[] nums, int left, int right){
        
        while(left < right){
            swap(nums, left,right);
            left ++;
            right --;
        }
        
    }
}