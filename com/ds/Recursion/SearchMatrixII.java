package com.ds.Recursion;
class SearchMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int row = 0; int col = n - 1;
        
        while(row >=0 && row < m && col < n && col >=0){
        
        int pivot = matrix[row][col];
        
        if(pivot == target){
            return true;
        }else if(pivot > target){
           col--;   
        }else {
            row++;
         }
        }
      return false;  
    }
}