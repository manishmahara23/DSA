class Solution {
    public long countPairs(int n, int[][] edges) {
        // 1. Graph (Adjacency List) banate hain
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Undirected graph hai toh dono taraf edge add hogi (u->v aur v->u)
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        long totalPairs = 0;
        long unreachedNodes = n; // Shuru me saare nodes unreached hain
        
        // 2. Har node par ghoomte hain
        for (int i = 0; i < n; i++) {
            // Agar node pehle se kisi group me count nahi hua hai
            if (!visited[i]) {
                // DFS se is pure group (component) ka size nikalenge
                long currentGroupSize = dfs(i, graph, visited);
                
                // Is group ke log bache hue baaki logo se nahi mil sakte
                unreachedNodes -= currentGroupSize; 
                totalPairs += currentGroupSize * unreachedNodes;
            }
        }
        
        return totalPairs;
    }
    
    // DFS function jo ek group ke saare members count karke laata hai
    private int dfs(int node, List<Integer>[] graph, boolean[] visited) {
        visited[node] = true;
        int count = 1; // Is node ko count kiya
        
        // Iske saare dosto par jao
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                count += dfs(neighbor, graph, visited); // Dosto ke dosto ko bhi jodo
            }
        }
        
        return count; // Total size return karo
    }
}