class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if(connections.length < n-1){
            return -1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : connections){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int components = 0;

        for(int i=0; i<n ; i++){
            if(!visited[i]){
                components++;
                dfs(i,adj,visited);
            }
        }
        return components -1;
    }
    private void dfs(int node, List<List<Integer>>adj , boolean[] visited){
        visited[node] = true;
        for(int neighbour: adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,adj,visited);
            }
        }
    }
}