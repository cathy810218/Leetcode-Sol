public class Codec {
    // Encodes a tree to a single string
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append(" ");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        // use split to get an array of strings.
        String[] strs = data.split(" ");

        TreeNode root = dfs(strs, 0, list.length - 1);
    }

    private TreeNode dfs(String[] strs, int low, int high) {
        if (low > high) {
            return null;
        }
        int curr = Integer.parseInt(strs[low]);
        TreeNode node = new TreeNode(curr);

        // Need to find the index that divides left and right substree
        // low+1 -> because low is current node.val
        int divIndex = findDivision(strs, low+1, high, node.val);

        node.left = dfs(strs, low + 1, divIndex - 1); // left subtree
        node.right = dfs(strs, divIndex, high); // right subtree

        return node;
    }

    // Find the index of the element that's greater than val (node.val)
    private int findDivision(String[] strs, int low, int high, int val) {
        int result = low;

        // Doing this to prevent indexOutOfBounds when strs = ["2", "1"]
        while (result <= high) {
            if (Integer.parseInt(strs[result]) > val) {
                // find the index
                break;
            }
            result++;
        }
        return result;
    }
}
