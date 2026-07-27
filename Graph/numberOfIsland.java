class Solution {
    public int numIslands(char[][] grid) {
        // Agar grid khali hai, toh 0 islands hain
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int islandCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Poore grid par ek-ek karke traverse karenge
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                // Agar '1' mila, matlab ek naya anjaan island mila!
                if (grid[r][c] == '1') {
                    islandCount++; // Island ki ginti badhao
                    
                    // DFS call karke is pure island ke saare '1' ko '0' kar do
                    sinkIsland(grid, r, c);
                }
            }
        }
        
        return islandCount;
    }
    
    private void sinkIsland(char[][] grid, int r, int c) {
        // Base Conditions: Boundary check aur paani ('0') check
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0') {
            return; // Grid se bahar hain ya paani hai, toh chupchap ruko
        }
        
        // Is land ko '0' (paani) bana do taaki ye dobara count na ho
        grid[r][c] = '0';
        
        // Ab 4 directions me jaakar baaki bache land padosiyon ko bhi dooba do
        sinkIsland(grid, r + 1, c); // Neeche
        sinkIsland(grid, r - 1, c); // Upar
        sinkIsland(grid, r, c + 1); // Right
        sinkIsland(grid, r, c - 1); // Left
    }
}
