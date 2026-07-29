class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return mat;
        
        int rows = mat.length;
        int cols = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        
        // Step 1: Saare 0s ko queue mein daalein aur 1s ko unvisited (-1) mark karein
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 0) {
                    queue.offer(new int[]{r, c}); // 0 khud ek source hai
                } else {
                    mat[r][c] = -1; // -1 ka matlab abhi iska distance nahi nikalna gaya
                }
            }
        }
        
        // 4 directions: Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Step 2: Multi-Source BFS chalaein
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            
            for (int[] dir : directions) {
                int nextR = r + dir[0];
                int nextC = c + dir[1];
                
                // Boundary check aur check ki kya padosi cell unvisited (-1) hai
                if (nextR >= 0 && nextR < rows && nextC >= 0 && nextC < cols && mat[nextR][nextC] == -1) {
                    // Padosi ka distance = current cell ka distance + 1
                    mat[nextR][nextC] = mat[r][c] + 1; 
                    queue.offer(new int[]{nextR, nextC}); // Naye updated cell ko queue mein dalein
                }
            }
        }
        
        return mat;
    }
}
