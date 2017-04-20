/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) { return null;}
        
        return helper(head, null);
    }
    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) { return null; }
        
        ListNode runner = head;
        ListNode walker = head;

        while (runner != tail && runner.next != tail) {
            runner = runner.next.next;
            walker = walker.next;
        }

        TreeNode root = new TreeNode(walker.val);
        root.left = helper(head, walker);
        root.right = helper(walker.next, tail);
        
        return root;
    }
}