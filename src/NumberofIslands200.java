public class NumberofIslands200 {
    public int numIslands(char[][] grid) {
        int rows_size = grid.length;
        int col_size = grid[0].length;
        int count = 0;
        for(int i = 0; i < rows_size; i++){
            for(int j = 0; j < col_size; j++){
                if(grid[i][j] == 1){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int row, int col){
        int rows_size = grid.length;
        int col_size = grid[0].length;
        grid[row][col] = 2;
        if(row > 0 && grid[row-1][col] == '1'){
            dfs(grid, row - 1, col);
        }
        if(col > 0 && grid[row][col-1] == '1'){
            dfs(grid, row, col-1);
        }
        if(row < rows_size - 1 && grid[row+1][col] == '1'){
            dfs(grid, row+1, col);
        }
        if(col < col_size - 1 && grid[row][col+1] == '1'){
            dfs(grid, row, col+1);
        }
    }
}
