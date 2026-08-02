class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Graph aur Indegree array initialize kara
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        
        // 2. Graph build kara aur indegree calculate kara
        // prerequisites[i] = [a, b] matlab b pehle karo, fir a hoga (b -> a)

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        
        // 3. Jinki indegree 0 hai, unhe queue me daalein

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0 ; i< numCourses ; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        // 4. BFS chalaein aur courses count karein
        
        int courseCompleted = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            courseCompleted++;
        
            // Neighbors ki indegree kam karein
            for(int neighbour : adj.get(curr)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        // 5. Agar saare courses process ho gaye, toh koi cycle nahi thi

        return courseCompleted == numCourses;
    }
}