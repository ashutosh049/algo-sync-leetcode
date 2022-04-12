class Solution {
    int[][] board;
    int[][] zeroState;
    int rows;
    int cols;
    private static final int[] ROW_OFF_SET = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
    private static final int[] COL_OFF_SET = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };

    public void gameOfLife(int[][] board) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.zeroState = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                zeroState[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                updateCellState(i, j);
            }
        }
    }

    private void updateCellState(int i, int j) {
        // apply bussiness logic, verify update board via zeroState
        int liveCell = 0;
        for (int k = 0; k < 8; k++) {
            int r = i + ROW_OFF_SET[k];
            int c = j + COL_OFF_SET[k];
            if (isValidCellPos(r, c) && zeroState[r][c] == 1) {
                liveCell++;
            }
        }

        if (zeroState[i][j] == 1) {
            if (liveCell < 2 || liveCell > 3) {
                board[i][j] = 0;
            }
        } else {
            if (liveCell == 3) {
                board[i][j] = 1;
            }
        }
    }

    private boolean isValidCellPos(int i, int j) {
        return i >= 0 && i < rows && j >= 0 && j < cols;
    }
}
