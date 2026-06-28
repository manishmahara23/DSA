public class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case: both nodes are null
        if (root1 == null && root2 == null) {
            return true;
        }
        // Base case: one node is null, or values do not match
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }

        // Case 1: The subtrees are already in the same orientation (no flip needed)
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        
        // Case 2: The subtrees are flipped
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

        // True if either condition satisfies the flip equivalence
        return noFlip || flip;
    }
}