class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if(root == null) return ans;

        Queue <TreeNode> q =new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelSize = q.size();

            for(int i=0 ;i<levelSize;i++){
                TreeNode node = q.poll();
                if(i == levelSize -1){
                    ans.add(node.val);
                }
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
        }
        return ans;
    }
}