import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class NQueens {
	/**
	 * 时间复杂度: O(n!)
	 * 空间复杂度: O(n)
	 */
	public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] chessboard = new char[n][n];
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');
        } 
        dfs(res, chessboard, n, 0);
        return res;
    }

    private void dfs(List<List<String>> res, char[][] chessboard, int n, int row) {
        if (row == n) {
            res.add(arrayToList(chessboard));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                dfs(res, chessboard, n, row + 1);
                chessboard[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chessboard) {
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> arrayToList(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
}
