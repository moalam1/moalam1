package com.ds.Recursion;

public class Reverse {
	static ListNode prev = null;
	public static ListNode reverse(ListNode head) {

		ListNode current = head;
		
		
		helper(current);
		return prev;

	}

	public static void helper(ListNode current) {

		if (current == null) {
			return ;
		}
		System.out.println("** "+current.val);

		ListNode next = current.next;
		current.next = prev;
		prev = current;
		current = next;
		System.out.println(" -  "+prev.val);
		helper(current);


	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		ListNode res = reverse(node1);

		ListNode current = res;
		while (current != null) {

			System.out.println(current.val);
			current = current.next;

		}
	}

}

class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int val) {

		this.val = val;
		this.next = null;

	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}
