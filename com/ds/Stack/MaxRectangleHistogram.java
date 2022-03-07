package com.ds.Stack;

import java.util.*;

public class MaxRectangleHistogram {

	public static void main(String[] args) {
		MaxRectangleHistogram m = new MaxRectangleHistogram();
		int[] array = new int[] { 3,1,3,2,2 };
		int area= m.maxRectangleHist(array);
		System.out.println(area);

	}

	private int maxRectangleHist(int[] heights) {

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

	

	private int[] NSR(int[] heights) {

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
				} 
				else{
					list.add(0, stack.peek().index);
				}
				

			} else if (!stack.isEmpty() && stack.peek().getValue() < heights[i]) {

				list.add(0, stack.peek().index);
			}
				stack.push(new Pair(heights[i], i));
			
		}

		for (int i = 0; i < right.length; i++) {
			right[i] = list.get(i);
		}

		return right;
	}
	
	private int[] NSL(int[] heights) {

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
				} 
				else {  
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


