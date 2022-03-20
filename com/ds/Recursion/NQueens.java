package com.ds.Recursion;

public class NQueens {
	
	static int totalSolution = 0;
	 
	 public static void main(String[] args) {
		 System.out.println(totalNQueens(8));
	 }
	 
	 public static int totalNQueens(int n) {
	        
	        int[][] chess = new int[n][n];
	        helper(chess,0,n);
	        return totalSolution;
	        
	    }
	    
	    public static void helper(int[][] chess, int row, int n){
	        
	        
	        for(int col = 0 ; col < n ; col++ ){
	            
	            if(isNotUnderAttack(chess,row, col)){
	               chess[row][col] = 1;
	             }else{
	                continue;
	            }
	            
	            if(row + 1 == n){
	                totalSolution++;
	            }else{
	                helper(chess, row + 1, n);
	            }
	            
	            chess[row][col] = 0;
	            
	        }
	        
	    }
	    
	    public static boolean checkTheRow(int[][] chess, int row, int col){
	        
	        for(int i = 0; i < chess.length;i++){
	            
	            if(chess[i][col] == 1){
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    public static boolean checkTheCol(int[][] chess, int row, int col){
	        
	        for(int i = 0; i < chess.length;i++){
	            
	            if(chess[row][i] == 1){
	                return false;
	            }
	        }
	        return true;
	    }
	    
	     public static boolean checkTheDiagonal(int[][] chess, int row, int col){
	       
	    	 int i = row;
	    	 int j = col;
	    	 
	    	 while(i > 0 && j > 0) {
	    		 
	    		 if(chess[ i - 1 ][j - 1] == 1) {
	    			 return false;
	    		 }
	    		 i --;j--;
	    	 }
	    	 i = row;j = col;
	    	 while(i < chess.length - 1  && j < chess.length - 1) {
	    		 
	    		 if(chess[ i + 1 ][j + 1] == 1) {
	    			 return false;
	    		 }
	    		 i ++;j++;
	    		 
	    	 }
	    	 i = row;
	    	 j = col;
	    	 while(i < chess.length - 1 && j >0 ) {
	    		 
	    		 if(chess[ i + 1 ][j - 1] == 1) {
	    			 return false;
	    		 }
	    		 i ++;j--;
	    		 
	    	 }
	    	 
	    	 i = row;
	    	 j = col;
	    	 while(i >0  && j  < chess.length - 1 ) {
	    		 
	    		 if(chess[ i - 1 ][j + 1] == 1) {
	    			 return false;
	    		 }
	    		 i --;j ++;
	    		 
	    	 }

	        return true;
	    }
	    
	    public static boolean isNotUnderAttack(int[][] chess, int row, int col){
	        
	        boolean notUnderAttack = true;
	        
	        boolean rowCheckPass = checkTheRow(chess, row, col);
	        if(!rowCheckPass){
	            return false;
	        }
	        
	        boolean colCheckPass = checkTheCol(chess, row, col);
	        if(!colCheckPass){
	            return false;
	        }
	        
	        boolean diagonalCheckPass = checkTheDiagonal(chess, row, col);
	        if(!diagonalCheckPass){
	            return false;
	        }
	        
	        
	        return notUnderAttack;
	    }

}
