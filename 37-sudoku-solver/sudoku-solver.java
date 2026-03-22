
class Solution {
    public boolean isSafe(char sudoku[][],int row,int col,char digit){
        //column
        for(int i=0;i<=8;i++){
            if(sudoku[i][col]==digit){
                return false;
            }
        }
        //row
        for(int j=0;j<=8;j++){
            if(sudoku[row][j]==digit){
                return false;
            }
        }
        //grid
        int sr=(row/3)*3;
        int sc=(col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }
    public  boolean sudokuSolver(char[][]sudoku,int row,int col){

        //Base Case
        if(row==9 && col==0){
            return true;
        }

        //recursion
        int nextRow=row;
        int nextCol=col+1;

        if(col+1==9){
            nextRow=row+1;
            nextCol=0;
        }

        if(sudoku[row][col]!='.'){
            return sudokuSolver(sudoku,nextRow,nextCol);
        }

        for(char digit='1';digit<='9';digit++){
            if(isSafe(sudoku,row,col,digit)){
                sudoku[row][col]=digit;

                if(sudokuSolver(sudoku,nextRow,nextCol)){
                    return true;
                }
                sudoku[row][col]='.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] sudoku) {

        sudokuSolver(sudoku,0,0);
        
    }
}