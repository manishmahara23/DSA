class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;

        // check for left and right subtree
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        // if both return some value then root is the LCA
        if(left!=null && right!=null) return root;

        // other wise return non null subtree
        return left!=null ? left : right;
    }
}