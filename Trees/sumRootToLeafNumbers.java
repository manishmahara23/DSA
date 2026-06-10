class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // 1. Calculate path value up to the current node
        currentSum = currentSum * 10 + node.val;

        // 2. If it's a leaf node, return the completed path value
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // 3. Accumulate sums from left and right subtrees
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);

        return leftSum + rightSum;
    }
}