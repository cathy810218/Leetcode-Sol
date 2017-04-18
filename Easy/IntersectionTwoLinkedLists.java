public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    int countA = 0;
    int countB = 0;
    
    while (a != null) {
        countA ++;
        a = a.next;
    }

    while (b != null) {
        countB++;
        b = b.next;
    }
    int diff = countA - countB;
    // reset nodes
    a = headA;
    b = headB;
    
    if (diff > 0) {
        // countA > countB    
        while (diff > 0) {
            a = a.next;
            diff --;
        }
    } else {
        // countB > countA
        while (diff < 0) {
            b = b.next;
            diff++;
        }
    }
    
    while (a != null) {
        if (a == b) {
            return a;
        }
        a = a.next;
        b = b.next;
    }
    return null;   
}