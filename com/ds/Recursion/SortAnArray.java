class SortAnArray {
    public int[] sortArray(int[] nums) {
        
        if(nums.length <= 1) return nums;
        
        int pivot = nums.length / 2;
        
        
        int[] leftList = sortArray(Arrays.copyOfRange(nums,0, pivot));
        int[] rightList = sortArray(Arrays.copyOfRange(nums,pivot, nums.length ));
        
        
        return merge(leftList, rightList);
        
    }
    
    public int[] merge(int[] leftList , int[] rightList){
        
        int[] res = new int[ leftList.length + rightList.length];
        
        int i = 0, j = 0, k = 0;
        
        while(i < leftList.length && j < rightList.length){
            
            if(leftList[i] <= rightList[j]){
                res[k++] = leftList[i++];
            }else if(rightList[j] <= leftList[i]){
                res[k++] = rightList[j++];
            }
            
        }
        
        
        while(i < leftList.length){
             res[k++] = leftList[i++];
        }
        
         while(j < rightList.length){
             res[k++] = rightList[j++];
        }
        
        return res;
        
    }
}