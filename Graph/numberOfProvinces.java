class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provence = 0;
        
        for(int i=0; i<n ;i++){
            if(!visited[i]){
                provence++;
                dfs(isConnected, visited,i);
            }
        }
        return provence;
    }
    private void dfs(int[][] isConnected, boolean[] visited, int city){
        visited[city] = true;

        for(int neighbor = 0;neighbor<isConnected.length; neighbor++){
            if(isConnected[city][neighbor]==1 && !visited[neighbor]){
                dfs(isConnected, visited, neighbor);
            }
        }
    }
}