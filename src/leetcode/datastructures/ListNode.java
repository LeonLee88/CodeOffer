package leetcode.datastructures;

import java.security.InvalidParameterException;

/**
 * @author leon
 * 
 *
 */
public class ListNode {
	public int val;
	public ListNode next;
	public ListNode prev;

	/**
	 * Constructor of this class
	 */
	public ListNode(int val) {
		this.val = val;
		prev = null;
		next = null;
	}

	/**
	 * Transform an integer array to an a List
	 * 
	 * @param int[] array Integer array to be transform
	 * 
	 * @return ListNode head node of list
	 */
	public static ListNode arrayToList(int[] array){
		if(array == null || array.length == 0){
			throw new InvalidParameterException("Input array cannot be Null or empty");
		}
		ListNode head = new ListNode(array[0]);
		ListNode prev = head;
		for(int i=1; i< array.length; i++){
			prev.next = new ListNode(array[i]);
			prev = prev.next;
		}
		return head;
	}
}
