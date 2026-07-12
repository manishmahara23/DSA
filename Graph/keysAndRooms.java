class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();

        boolean[] visited = new boolean[n];
        
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;

        queue.offer(0);
        int count =1;

        while(!queue.isEmpty()){
            int currRoom = queue.poll();

            for(int key : rooms.get(currRoom)){
                if(!visited[key]){
                    visited[key] = true;
                    queue.offer(key);
                    count++;

                    if(count == n){
                        return true;
                    }
                }
            }
        }
        return count == n;
    }
}