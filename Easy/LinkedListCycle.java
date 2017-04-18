public boolean hasCycle(ListNode head) {
    if (head == null || head.next == null ) {
        return false;
    }
    ListNode runner = head.next;
    ListNode walker = head;
    while (runner != walker) {
        if (runner == null || runner.next == null) {
            return false;
        }
        runner = runner.next.next;
        walker = walker.next;
    }
    return true;
}