class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Step 1: Row aur Column dono ka order nikalen topoSort se
        
        List<Integer> rowOrder =  topoSort(rowConditions, k);
        List<Integer> colOrder =  topoSort(colConditions, k);
        
        // Agar kisi ek mai bhi cycle mili (order size k nahi hua), toh impossible hai
        
        if(rowOrder.isEmpty() || colOrder.isEmpty()){
            return new int[0][0];
        }
        
        // Step 2: Har element ki row aur col position ko store karne ke liye arrays banayein
    
        int[] rowPos = new int[k+1];
        int[] colPos = new int[k+1];

        for(int i=0 ;i<k;i++){
            rowPos[rowOrder.get(i)]=i;
            colPos[colOrder.get(i)]=i;
        }
        
        // Step 3: Result matrix ko fill karein
        int[][] matrix = new int[k][k];
        for(int num=1;num<=k;num++){
            matrix[rowPos[num]][colPos[num]] = num;
        }
        return matrix;
    }
    // Topological Sort function 
    private List<Integer> topoSort(int[][] conditions, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[k+1];

        for(int i=0; i<=k; i++){
            adj.add( new ArrayList<>());
        }
        
        // Graph build karna aur In-degree track karna

        for(int[] condition : conditions){
            int u = condition[0];
            int v = condition[1];

            adj.get(u).add(v);
            indegree[v]++;
        }
        
        // Queue mai unhe dalein jinki in-degree 0 hai (jinki koi dependency nahi hai)

        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=k;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while(!q.isEmpty()){
            int curr = q.poll();

            order.add(curr);
            for(int neighbour: adj.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    q.offer(neighbour);
                }
            }
        }
 
        // Agar saare k elements order mai aa gaye, toh list return karein, nahi toh khali list (Cycle detected)
        return order.size()==k ? order: new ArrayList<>();
    }
}
