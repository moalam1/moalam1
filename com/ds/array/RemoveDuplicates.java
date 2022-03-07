package com.ds.array;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        
        if ( nums.length == 0 ) return -1;
        if ( nums.length == 1 ) return nums[0];
        
        int p = 0; int q = 1;
        
        while( q < nums.length ){
            
            if( nums[q] == nums[p] ){
                q++;
            }else {
                nums[ p + 1] = nums[q];
                p++;
            }
            
        }
        
        return p + 1;
    }
}