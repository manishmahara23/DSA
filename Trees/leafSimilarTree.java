class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Extract leaf values for both trees
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        
        // Compare the two lists
        return leaves1.equals(leaves2);
    }
    
    private void dfs(TreeNode node, List<Integer> leafValues) {
        if (node == null) {
            return;
        }
        
        // If the node is a leaf, add its value to the list
        if (node.left == null && node.right == null) {
            leafValues.add(node.val);
        }
        
        // Recurse for left and right subtrees
        dfs(node.left, leafValues);
        dfs(node.right, leafValues);
    }
}
