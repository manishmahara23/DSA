class Solution {
    // 1. Find function with Path Compression
    private int find(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }
        // Path compression: parent ko directly ultimate parent set karna
        return parent[node] = find(parent[node], parent);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        // Shuru me har node khud ka parent hai
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        // Har edge par iterate karein
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            // Dono nodes ke ultimate parents dhoodhein
            int rootU = find(u, parent);
            int rootV = find(v, parent);

            // Agar dono ka parent same hai, matlab cycle mil gayi!
            if (rootU == rootV) {
                return edge; 
            }

            // Agar same nahi hai, to dono ko union (connect) kar do
            parent[rootU] = rootV;
        }

        return new int[0];
    }
}