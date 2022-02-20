class Solution {
    
    int row;
    int col;
    char[][] matrix;
    int[][] memo;
    
    public int maximalSquare(char[][] matrix) {
     
        int maxArea = 0;
        
        this.row = matrix.length;
        this.col = matrix[0].length;
        this.matrix = matrix;
        this.memo = new int[row][col];
        
        // If matrix has only 1 row
        if(row ==  1){
            for(int i=0; i < col; i++){
              if(matrix[0][i] == '1'){
                  maxArea = 1;
                  break;
              } 
            }
        }
        
        // If matrix has only 1 col
        if(col ==  1){
            for(int i=0; i < row; i++){
               if(matrix[i][0] == '1'){
                  maxArea = 1;
                  break;
              }
            }
        }
        
        // If matrix has more than 1 row and 1 col
        int maxSoFar = dp(0,0);
        maxArea = maxSoFar * maxSoFar;
        
        return maxArea;
        
    }
    
    private int dp(int i, int j){
        if(isValid(i,j)){
            
            int maxSoFar = 0;
            
            for(int r=i; r < row; r++){
                for(int c=j; c < col; c++){
                    if(matrix[r][c] == '1'){
                        int upperVal = getValue(memo, r-1, c);
                        int leftVal = getValue(memo, r, c-1);
                        int upperLeftDiagonalVal = getValue(memo, r-1, c-1);
                        memo[r][c] = min(upperVal, leftVal, upperLeftDiagonalVal) +1;
                        maxSoFar = Math.max(maxSoFar, memo[r][c]);
                    }
                }   
            }
            return maxSoFar;
        }
        
        return 0;
    }
    
    private int getValue(int[][] arr, int i, int j){
        if(isValid(i,j)){
            return arr[i][j];
        }
        return 0;
    }
    
    private boolean isValid(int i, int j){
        return i >= 0 && i< row && j >= 0 && j< col;
    }
    
    private int min(int a, int b, int c){
        return Math.min(Math.min(a,b), c);
    }
}