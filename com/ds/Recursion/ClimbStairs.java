package com.ds.Recursion;

import java.util.*;

class ClimbStairs {

	public static int fib(int n) {

		if (n == 0 || n == 1)
			return n;

		Map<Integer, Integer> cache = new HashMap<>();
		
		cache.put(1, 1);
		
		cache.put(2, 2);

		return helper(n, cache);

	}

	public static int helper(int n, Map<Integer, Integer> cache) {

			if(cache.containsKey(n)) {
				return cache.get(n);
			}
			cache.put(n, helper(n - 1, cache) + helper(n - 2, cache));
		    return cache.get(n);
	}

	public static void main(String[] args) {

		System.out.println(fib(5));

	}
}