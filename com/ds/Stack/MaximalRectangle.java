package com.ds.Stack;

import java.util.ArrayList;
import java.util.*;

public class MaximalRectangle {
	public static void main(String[] args) {
		char[][] matrix = {{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}};
		 System.out.println(maximalRectangle(matrix));
		}
	  
	
	public static int maximalRectangle(char[][] matrix) {

		int[] heights = new int[matrix[0].length];
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length; i++) {

			for (int j = 0; j < matrix[i].length; j++) {
				int val = matrix[i][j] - '0';
				if (val == 0) {
					heights[j] = 0;
				} else {
					heights[j] += val ;
				}

			}
			maxArea = Math.max(maxArea, largestRectangleArea(heights));
		}

		return maxArea;

	}
	 public static int largestRectangleArea(int[] heights) {
	     
	        int maxArea = Integer.MIN_VALUE;

			int[] rightArray = NSR(heights);
			int[] leftArray = NSL(heights);

			for (int i = 0; i < heights.length; i++) {

				int len = rightArray[i] - leftArray[i] - 1;
				int area = heights[i] * len;
				maxArea = Math.max(maxArea, area);

			}

			return maxArea;
	        
	    }
	    
	    private static int[] NSR(int[] heights) {

			int[] right = new int[heights.length];

			Stack<Pair> stack = new Stack<>();

			List<Integer> list = new ArrayList<>();

			for (int i = heights.length - 1; i >= 0; i--) {

				if (stack.isEmpty()) {
					
					list.add(0, heights.length);
					
				} else if (!stack.isEmpty() && stack.peek().getValue() >= heights[i]) {

					while (!stack.isEmpty() && stack.peek().getValue() >= heights[i]) {
						stack.pop();
					}

					if (stack.isEmpty()) {
						list.add(0, heights.length);
					} else {
						list.add(0, stack.peek().index);
					}

				} else if (!stack.isEmpty() && stack.peek().getValue() < heights[i]) {

					list.add(0, stack.peek().index);
				}
	            
				stack.push(new Pair(heights[i], i));
			}

			for (int i = 0; list.size() > 0 && i < right.length; i++) {
				right[i] = list.get(i);
			}

			return right;
		}
		
		private static int[] NSL(int[] heights) {

			int[] left = new int[heights.length];

			Stack<Pair> stack = new Stack<>();

			for (int i = 0; i < heights.length; i++) {

				if (stack.isEmpty()) {
					left[i] = -1;
					
				} else if (!stack.isEmpty() && stack.peek().getValue() >= heights[i]) {

					while (!stack.isEmpty() && stack.peek().getValue() >= heights[i]) {
						stack.pop();
					}

					if (stack.isEmpty()) {
						left[i] = -1;
					} else {
						left[i] = stack.peek().index; 
					}

				} else if (!stack.isEmpty() && stack.peek().getValue() < heights[i]) {
						
					left[i] = stack.peek().index; 
				}
					stack.push(new Pair(heights[i], i));
			}

		
			return left;
		}

	}

	
