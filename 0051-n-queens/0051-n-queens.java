import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(res, board, 0, n);
        return res;
    }

    private void backtrack(List<List<String>> res, char[][] board, int row, int n) {
        if (row == n) {
            res.add(construct(board));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';
                backtrack(res, board, row + 1, n);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(char[][] board, int row, int col, int n) {
        for (int i = 0; i < row; i++) if (board[i][col] == 'Q') return false;
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) if (board[i][j] == 'Q') return false;
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) if (board[i][j] == 'Q') return false;
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) res.add(new String(row));
        return res;
    }
}
