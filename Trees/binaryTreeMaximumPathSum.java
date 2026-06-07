class Solution {
    private int maxPathSum;

    public int maxPathSum(TreeNode root) {
        maxPathSum = Integer.MIN_VALUE;
        gainFromNode(root);
        return maxPathSum;
    }

    private int gainFromNode(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 1. Gain from subtrees, ignoring negative paths
        int leftGain = Math.max(gainFromNode(node.left), 0);
        int rightGain = Math.max(gainFromNode(node.right), 0);

        // 2. Price of a new path with current node as the highest point
        int currentPathSum = node.val + leftGain + rightGain;

        // 3. Update global maximum
        maxPathSum = Math.max(maxPathSum, currentPathSum);

        // 4. Return the maximum gain the parent node can get
        return node.val + Math.max(leftGain, rightGain);
    }
}