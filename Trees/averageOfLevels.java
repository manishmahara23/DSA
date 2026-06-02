class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            double levelSum = 0;

            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                levelSum += node.val;

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
            result.add(levelSum/size);
        }
        return result;
    }
}