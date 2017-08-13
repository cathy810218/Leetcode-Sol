# Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree
````
    1
   / \
  2   3
     / \
    4   5
````

as `"[1,2,3,null,null,4,5]"`, just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.


-----------------

## Sol

We use pre-order traversal to serialize the tree and then also the same to deserialize it.

So pre-order is: root, left, right

We need to create a helper method to generate this string.
If the current node is `null`, then we just append a `"null"` string

````java
private void serialize(TreeNode node, StringBuilder sb) {
    if (node == null) {
        sb.append("null ");
        return;
    }
    // else append the node.val
    sb.append(node.val);
    sb.append(" "); // with space
    // recursion
    serialize(node.left, sb);
    serialize(node.right, sb);
}
````

And in our public method, we just call this private helper and pass in the string builder.


For deserialize, it will be pretty much the same but reverse.
We will first create a Queue to store all the values.


````java
Queue<String> nodes = new LinkedList<>();
nodes.addAll(Arrays.asList(data.split(" ")));
````
Because using queue, we can pop the first element.

In our private helper, you just need to pass in the queue `nodes`.
And each time when we call deserialize, we just need to pop the first element and check it's value.

````java

private TreeNode deserialize(Queue<String> nodes) {
    String node = nodes.remove();
    if (node.equals("null")) {
        return null;
    }
    TreeNode node = new TreeNode(Integer.valueOf(node));
    node.left = deserialize(nodes);
    node.right = deserialize(nodes);
    return node;
}

````
