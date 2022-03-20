package com.ds.TwoPointer;
class MoveZeros {
    public void moveZeroes(int[] nums) {
        
        if(nums.length == 0 ) return; //2,1
        
        int left = -1;
        
        for(int j = 0; j < nums.length; j++){
            
            if(nums[j] == 0 && left == -1){
                left = j;
            }
            if(nums[j] != 0 && left != -1){
                swap(nums, left , j);
                left++;
            }
        }
        
    }
    
     public void swap(int[] nums, int left, int right){
        
        int val = nums[left];
        nums[left] = nums[right];
        nums[right] = val;
        
    }
}