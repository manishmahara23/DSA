class Solution {

    private int camera = 0;
    private static final int NOT_COVERED = 0;
    private static final int HAS_CAMERA = 1;
    private static final int COVERED = 2;

    public int minCameraCover(TreeNode root) {
        if(dfs(root)==NOT_COVERED){
            camera++;
        }
        return camera;
    }
    private int dfs(TreeNode node){
        if(node == null) {
            return COVERED;
    }
    int left = dfs(node.left);
    int right = dfs(node.right);

    if(left == NOT_COVERED || right == NOT_COVERED){
        camera++;
        return HAS_CAMERA;
    }
    if(left == HAS_CAMERA || right == HAS_CAMERA){
        return COVERED;
    }
    return NOT_COVERED;
    }
}