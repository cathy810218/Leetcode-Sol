/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public ListNode reverseList(ListNode head) {
	if (head == null) {
		return head;
	}
	ListNode tmp = head.next;
	ListNode tmp2 = null;
	head.next = null;
	while (tmp != null) {
		tmp2 = tmp.next;
		tmp.next = head;
		head = tmp;
		tmp = tmp2;
	}
	return head;
}