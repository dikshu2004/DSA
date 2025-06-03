class Solution {
    private void solve(int col, int n, char board[][], int leftRow[], int upperDiagonal[], int lowerDiagonal[], List<List<String>> result){
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new String(board[i]));
            }
            result.add(list);
            return;
        }
        for(int row=0; row<n; row++){
            if(leftRow[row] == 0 && upperDiagonal[row + col] == 0 && lowerDiagonal[n-1 + col-row] == 0){
                board[row][col] = 'Q';
                leftRow[row] = 1;
                upperDiagonal[row + col] = 1;
                lowerDiagonal[n-1 + col-row] = 1;

                solve(col+1, n, board, leftRow, upperDiagonal, lowerDiagonal, result);

                board[row][col] = '.';
                leftRow[row] = 0;
                upperDiagonal[row + col] = 0;
                lowerDiagonal[n-1 + col-row] = 0;                
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char board[][] = new char[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, n, board, leftRow, upperDiagonal, lowerDiagonal, result);
        return result;
    }
}