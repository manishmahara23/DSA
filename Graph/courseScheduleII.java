class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list and in-degree array

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            int course = pre[0];
            int prerequisite = pre[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        
        // Step 2: Queue to store courses with in-degree 0

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        
        // Step 3: Process the queue

        int[] order = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            order[index++] = course;

            // Decrease in-degree of neighboring courses
            for(int neighbour : adj.get(course)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        // Step 4: Check if we finished all courses (no cycles)

        if(index == numCourses){
            return order;
        }
        
        // Cycle detected, return empty array
        return new int[0];
    }
}
