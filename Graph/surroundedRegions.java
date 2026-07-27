class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int rows = board.length;
        int cols = board[0].length;
        
        // 1. First aur Last COLUMN ke borders par 'O' check karo
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][cols - 1] == 'O') dfs(board, r, cols - 1);
        }
        
        // 2. First aur Last ROW ke borders par 'O' check karo
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[rows - 1][c] == 'O') dfs(board, rows - 1, c);
        }
        
        // 3. Poore board par ghoomo aur final transformation karo
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X'; // Jo ghire hue the, unhe 'X' kar diya
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O'; // Jo safe the, unhe wapas 'O' kar diya
                }
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c) {
        // Base cases: Boundary aur 'O' check
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        
        // Is 'O' ko 'T' (Temporary Safe) mark karo
        board[r][c] = 'T';
        
        // 4 directions me jaakar baaki jude hue 'O' ko bhi safe mark karo
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
