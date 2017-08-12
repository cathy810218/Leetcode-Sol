# Copy List with Random Pointer

A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

[Link to Leetcode](https://leetcode.com/problems/copy-list-with-random-pointer/)

[Link to Code](CopyListRandomPointer.java)


--------------------------------------------------

# SOL

Since the given list has not only the regular pointer, it also has random pointer for each node.
We need to "make a copy" of the given list instead of creating a pointers only.

Therefore, the best way to do it is to create a map that stores origin list node to be KEY and a copy node to be value.

Then later on, we can hook up the pointers.

So first, create a `HashMap`

Then we create another temp pointer to point to the head of given list so that we can go down to other nodes without losing the entire list.

**First step**

Make a copy

````java
RandomListNode temp = head;
while (temp != null) {
    map.put(temp, new RandomListNode(temp.label));
    temp = temp.next;
}
````


**Second step**

Set up pointers

````java
temp = head // reset temp
while (temp != null) {
    map.get(temp).next = map.get(temp.next);
    map.get(temp).random = map.get(temp.random);
    temp = temp.next;
}

return map.get(head); // to do this because we are returning a copy of the list
````
