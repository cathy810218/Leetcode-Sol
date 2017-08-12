public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null) {
        return null;
    }
    Map<RandomListNode, RandomListNode> map = new HashMap<>();

    RandomListNode temp = head;
    // Copy new nodes
    while (temp != null) {
        map.put(temp, new RandomListNode(temp.label));
        temp = temp.next;
    }

    // set up pointers
    temp = head;
    while (temp != null) {
        map.get(temp).next = map.get(temp.next);
        map.get(temp).random = map.get(temp.random);
        temp = temp.next;
    }
    return map.get(head);
}
