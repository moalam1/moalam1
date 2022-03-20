package com.ds.Recursion;

public class SudukuSolver {
	public static void main(String[] args) {
		char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'}};
	
				solveSudoku(board);
	
	}

	public static void solveSudoku(char[][] board) {

		helper(board, 0, 0);

	}

	public static boolean isValid(char[][] board, int row, int col, int value) {

		char c = (char) (value + '0');
		for (int i = 0; i < 9; i++) {

			if (board[i][col] == c) {
				return false;
			}
			if (board[row][i] == c)
				return false;
		}

		int rowBox = row / 3;
		int colBox = col / 3;

		for (int i = rowBox * 3; i < (rowBox + 1) * 3; i++) {
			for (int j = colBox * 3; j < (colBox + 1) * 3; j++) {

				if (board[row][col] == c) {
					return false;
				}

			}
		}

		return true;
	}

	public static boolean helper(char[][] board, int row, int col) {
		
		if(col == 9){
            row+= 1;
            col = 0;
        }
        if(row == 9) return true;
       
        if(board[row][col] != '.'){
              return  helper(board, row, col+1);
        }
        
        for(int i = 1; i <= 9; i++){
            
                if(!isValid( board,row, col, i)) continue;
                    board[row][col] = (char)(i + '0');
                    if(helper(board, row, col + 1)){
                        return true;
                    }
                    board[row][col] = '.';
                }
       return false;
	}
}
