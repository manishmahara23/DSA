class Solution {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Saare Land (1) cells ko queue mein daalein
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    queue.offer(new int[]{r, c});
                }
            }
        }
        
        // Edge Case: Agar grid mein sirf paani hai ya sirf zameen hai, toh -1 return karein
        if (queue.isEmpty() || queue.size() == rows * cols) {
            return -1;
        }
        
        int distance = -1; // -1 se shuru karenge kyunki pehla level distance 0 hota hai
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Level-by-Level BFS chalaein (Rotting Oranges wala loop size ke saath)
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++; // Har naye level par distance 1 badhega
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                
                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    
                    // Boundary check aur check ki kya agla cell Water (0) hai
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 0) {
                        grid[nextR][nextC] = 1; // Is water ko visited (Land) mark kar dein
                        queue.offer(new int[]{nextR, nextC});
                    }
                }
            }
        }
        
        return distance;
    }
}
