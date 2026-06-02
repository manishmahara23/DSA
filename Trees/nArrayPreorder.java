class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Stack<Node> s = new Stack<>();
        s.push(root);

        while(!s.isEmpty()){
            Node curr = s.pop();
            ans.add(curr.val);

            if(curr.children!=null){
                for(int i= curr.children.size()-1;i>=0;i--){
                    s.push(curr.children.get(i));
                }
            }
        }
        return ans;
    }
}