public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null || l2 == null) {
        return l1 == null ? l2 : l1;
    }

    ListNode result = null;
    if (l1.val < l2.val) {
        result = l1;
        l1 = l1.next;
    } else {
        result = l2;
        l2 = l2.next;
    }
    ListNode temp = result;

    while (l1 != null && l2 != null) {
        if (l1.val < l2.val) {
            temp.next = l1;
            l1 = l1.next;
        } else {
            temp.next = l2;
            l2 = l2.next;
        }
        temp = temp.next;
    }
    
    temp.next = l1 == null ? l2 : l1;

    return result;
}