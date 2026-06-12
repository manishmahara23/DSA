class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root,null,null);
    }

    private boolean validate(TreeNode node, Long low, Long high){
        if(node == null) return true;

        if(low!=null && node.val<=low){
            return false;
        }
        if(high !=null && node.val >=high){
            return false;
        }
        return validate(node.left,low,(long)node.val) && validate(node.right,(long)node.val,high);
    }
}