class Solution {
    private int maxDepth = 0;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // Step 1: Find the maximum depth of the tree
        maxDepth = findDepth(root);
        
        // Step 2: Traverse top-down to find the LCA
        return getLCA(root, 1);
    }

    private int findDepth(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(findDepth(node.left), findDepth(node.right));
    }

    private TreeNode getLCA(TreeNode node, int currentDepth) {
        if (node == null) return null;
        
        // If we reach a leaf node at max depth, it's a candidate
        if (currentDepth == maxDepth) return node;

        TreeNode left = getLCA(node.left, currentDepth + 1);
        TreeNode right = getLCA(node.right, currentDepth + 1);

        // If both sides return a valid node, this current node is the LCA
        if (left != null && right != null) return node;
        
        // Otherwise, return whichever side found the deepest node(s)
        return left != null ? left : right;
    }
}
