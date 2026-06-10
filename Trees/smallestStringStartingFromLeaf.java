class Solution {
    private String answer = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return answer;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        // Add current character
        path.append((char) ('a' + node.val)); //97 + node.val

        // Leaf node
        if (node.left == null && node.right == null) {

            String current =
                new StringBuilder(path).reverse().toString();

            // 
            if (answer == null || current.compareTo(answer) < 0) {
                answer = current;
            }
        }

        dfs(node.left, path);
        dfs(node.right, path);

        path.deleteCharAt(path.length() - 1);
    }
}