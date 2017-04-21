public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
        return l1 == null ? l2 : l1;
    }
    
    int carry = 0;
    ListNode result = new ListNode(0);
    ListNode listA = l1, listB = l2, temp = result;

    while (listA != null || listB != null) {
        int a = listA == null ? 0 : listA.val;
        int b = listB == null ? 0 : listB.val;
        int sum = a+ b + carry;
        carry = sum > 9 ? 1 : 0;
        temp.next = new ListNode(sum % 10);
        temp = temp.next;
        if (listA != null) {
            listA = listA.next;
        }
        if (listB != null) {
            listB = listB.next;
        }
    }
    
    // if need extra node
    if (carry > 0) {
        temp.next = new ListNode(1);
    }
    return result.next;
}