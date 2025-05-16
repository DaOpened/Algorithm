package week04.tree.problems.maxDepthofBinaryTree;

public class Solution {
    public int maxDepth(TreeNode root) {
        int maxHeight = 0;

        if(root == null)
            return maxHeight;

        if(root.left != null) {
            maxHeight = Math.max(maxHeight, maxDepth(root.left));
        }

        if(root.right != null) {
            maxHeight = Math.max(maxHeight, maxDepth(root.right));
        }

        return maxHeight + 1;
    }
}
