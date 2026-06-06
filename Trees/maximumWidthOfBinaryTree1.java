class Solution {
    private int maxWidth = 0;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxWidth = 0; // Reset for each function call
        
        // Stores the index of the first (leftmost) node encountered at each depth level
        List<Integer> startIndicesOfLevels = new ArrayList<>();
        
        dfs(root, 0, 1, startIndicesOfLevels);
        return maxWidth;
    }

    private void dfs(TreeNode node, int depth, int index, List<Integer> startIndicesOfLevels) {
        if (node == null) return;

        // If this is the first time we visit this depth level, it must be the leftmost node
        if (depth == startIndicesOfLevels.size()) {
            startIndicesOfLevels.add(index);
        }

        // Calculate the width for the current node relative to the leftmost node of this level
        int firstIndexAtLevel = startIndicesOfLevels.get(depth);
        maxWidth = Math.max(maxWidth, index - firstIndexAtLevel + 1);

        // Crucial: DFS must visit left child before right child to guarantee leftmost node discovery
        dfs(node.left, depth + 1, 2 * index, startIndicesOfLevels);
        dfs(node.right, depth + 1, 2 * index + 1, startIndicesOfLevels);
    }
}