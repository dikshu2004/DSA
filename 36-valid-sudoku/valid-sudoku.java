import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";

                    if (!seen.add(b + "row" + i) ||
                        !seen.add("col" + j + b) ||
                        !seen.add("box" + i/3 + "-" + j/3 + b)) {
                        return false;
                    }
                }

            }
        }

        return true;
    }
}