package com.ds.Stack;

import java.util.Stack;

public class DailyTemp {
	public static void main(String[] args) {
		int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
		dailyTemperatures(temperatures);
	}
	public static int[] dailyTemperatures(int[] temperatures) {

		if (temperatures.length == 0)
			return new int[] {};

		int[] answers = new int[temperatures.length];

		Stack<Pair> stack = new Stack<>();
		//// [73,74,75,71,69,72,76,73]
		for (int i = temperatures.length - 1; i >= 0; i--) {

			if (stack.isEmpty()) {
				answers[i] = 0;
			} else if (temperatures[i] < stack.peek().value) {
				answers[i] = stack.peek().index - i;
			} else {

				while (!stack.isEmpty() && temperatures[i] >= stack.peek().value) {

					stack.pop();
				}

				if (stack.isEmpty()) {
					answers[i] = 0;
				} else {
					answers[i] = stack.peek().index;
				}
			}
			stack.push(new Pair(temperatures[i], i));

		}

		return answers;
	}
}
