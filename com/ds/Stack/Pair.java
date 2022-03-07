package com.ds.Stack;

public class Pair {

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	int value;
	int index;

	public Pair(int value, int index) {
		this.value = value;
		this.index = index;
	}
}
