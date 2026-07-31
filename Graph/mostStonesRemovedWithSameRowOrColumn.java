class Solution {
    private int find(int node, int[] parent){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = find(parent[node], parent);
    }

    private boolean union(int u, int v, int[] parent){
        int rootU = find(u, parent);
        int rootV = find(v, parent);

        if(rootU != rootV){
            parent[rootU] = rootV;
            return true;
        }
        return false;
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int[] parent = new int[n];

        for(int i=0; i<n; i++){
            parent[i] = i;
        }
        int totalGroups = n; 
        for(int i=0; i<n; i++){
            for(int j = i+1; j<n; j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    if(union(i,j,parent)){
                        totalGroups--;
                    }   
                }
            }
        }
        return n - totalGroups;
    }
}