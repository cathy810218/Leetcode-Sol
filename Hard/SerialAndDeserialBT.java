// Encodes a tree to a single string.
public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    serialize(root, sb);
    return sb.toString();
}

private void serialize(TreeNode node, StringBuilder sb) {
    if (node == null) {
        sb.append("null ");
        return;
    }

    sb.append(node.val);
    sb.append(' ');
    serialize(node.left, sb);
    serialize(node.right, sb);
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
    Queue<String> nodes = new LinkedList<>();
    nodes.addAll(Arrays.asList(data.split(" ")));
    return deserialize(nodes);
}

private TreeNode deserialize(Queue<String> nodes) {
    String node = nodes.remove();
    if (node.equals("null")) {
        return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(node));
    root.left = deserialize(nodes);
    root.right = deserialize(nodes);
    return root;
}
