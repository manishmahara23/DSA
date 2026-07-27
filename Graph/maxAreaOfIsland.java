class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Poore grid par ek-ek karke traverse karenge
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Agar '1' mila, matlab naya island mila!
                if (grid[r][c] == 1) {
                    // DFS call karke is pure island ka area nikalenge
                    int currentArea = dfs(grid, r, c);
                    // maxArea ko update karenge agar ye bada area hai
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int r, int c) {
        // Base Conditions: Boundary check aur paani (0) check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0) {
            return 0; // Agar grid se bahar hain ya paani hai, toh area 0 return karo
        }
        
        // Is '1' ko visit kar liya, toh ise '0' kar do taaki dobara visit na ho (Sinking the island)
        grid[r][c] = 0;
        
        // Is pixel ka khud ka count 1 hai
        int area = 1;
        
        // Ab 4 directions me jaakar baaki jude hue land ka area jod lo
        area += dfs(grid, r + 1, c); // Neeche
        area += dfs(grid, r - 1, c); // Upar
        area += dfs(grid, r, c + 1); // Right
        area += dfs(grid, r, c - 1); // Left
        
        return area;
    }
}