public class Solution {
    public boolean isValidSerialization(String preorder) {
        int diff = 0;
        for (String currChar : preorder.split(",")) {
            if (diff == 1) { return false; } 
            diff = currChar.equals("#") ? diff+1 : diff-1;
        }
        return diff == 1;
    }
}
