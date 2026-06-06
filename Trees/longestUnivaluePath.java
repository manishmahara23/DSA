class Solution {
    private int maxPath =0;
    public int longestUnivaluePath(TreeNode root) {   
        univaluePath(root);
        return maxPath;
    }
    private int univaluePath(TreeNode root){
        if(root == null) return 0;

        int leftPath = univaluePath(root.left);
        int rightPath = univaluePath(root.right);

        int validLeftPath =0;
        int validRightPath =0;

        if(root.left !=null && root.left.val == root.val){
            validLeftPath = leftPath +1;
        }
        if(root.right !=null && root.right.val == root.val){
            validRightPath = rightPath +1;
        }

        maxPath = Math.max(maxPath, validLeftPath + validRightPath );

        return Math.max(validLeftPath, validRightPath);
    }
}