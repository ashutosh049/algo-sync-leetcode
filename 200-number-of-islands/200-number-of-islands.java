class Solution {
    boolean[][] visited;
    char[][] grid;
    int rows;
    int cols;
    int count;

    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.rows = grid.length;
        this.cols = grid[0].length;
        this.count = 0;
        this.visited = new boolean[rows][cols];


        for(int i=0; i< rows; i++){
            for(int j=0; j< cols; j++){
                if(valid(i, j) && dfs(i, j)){
                    count++;
                }
                    
            }   
        }
        
        return count;
    }

    boolean dfs(int row, int col) {
        if (!valid(row, col)) {
            return false;
        }

        visited[row][col] = true;
        dfs(row, col + 1);
        dfs(row, col - 1);
        dfs(row+1, col);
        dfs(row-1, col);
        return true;
    }

    private boolean valid(int i, int j) {
        return i >= 0 
            && i < this.rows 
            && j >= 0 
            && j < this.cols 
            && grid[i][j] == '1'
            && !visited[i][j];
    }
}
