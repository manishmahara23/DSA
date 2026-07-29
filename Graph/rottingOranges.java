class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;
        
        // Step 1: Saare rotten oranges ko queue mein daalein aur fresh oranges ko count karein
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshOranges++;
                }
            }
        }
        
        // Agar koi fresh orange nahi hai, toh 0 minutes lagenge
        if (freshOranges == 0) return 0;
        
        int minutes = 0;
        // 4 directions: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: BFS traversal shuru karein
        while (!queue.isEmpty() && freshOranges > 0) {
            int size = queue.size();
            minutes++; // Har level pe 1 minute badhega
            
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];
                
                for (int[] dir : directions) {
                    int nextR = r + dir[0];
                    int nextC = c + dir[1];
                    
                    // Boundary check aur check ki kya orange fresh (1) hai
                    if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && grid[nextR][nextC] == 1) {
                        grid[nextR][nextC] = 2; // Orange ko rot karein
                        queue.offer(new int[]{nextR, nextC}); // Naye rotten orange ko queue mein dalein
                        freshOranges--; // Fresh orange ka count kam karein
                    }
                }
            }
        }
        
        // Agar abhi bhi koi fresh orange bacha hai, toh matlab sabhi tak sड़an nahi pahunch shti (-1)
        return freshOranges == 0 ? minutes : -1;
    }
}