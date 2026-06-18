class Solution {
    private int maxDepth = 0; 
    
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        maxDepth = findDepth(root);
        return getLCA(root,1);    
    }

    private int findDepth(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(findDepth(root.left),findDepth(root.right));
    }

    private TreeNode getLCA(TreeNode node, int currDepth){
        if(node == null) return null;
        if(currDepth == maxDepth) return node;

        TreeNode left = getLCA(node.left, 1+ currDepth);
        TreeNode right = getLCA( node.right, 1 + currDepth);

        if(left != null && right != null) return node;
        return left !=null ? left : right;
    }
}