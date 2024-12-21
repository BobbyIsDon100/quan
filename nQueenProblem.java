public class Main{
    final int N = 4;
    void printSol(int board[][]){
        for(int i = 0; i<N ; i++){
            for(int j = 0; j<N; j++)
            System.out.print(" "+board[i][j]+ " ");
            System.out.println();
        }
    }
    boolean isSafe(int board[][], int row, int col){
        int i, j;
        for(i = 0; i<col; i++)
        if(board[row][i] == 1)
        return false;
        for(i = row, j = col; i>=0 &&  j>=0; i--, j--)
        if(board[i][j] == 1)
        return false;
        for(i = row, j = col;j>=0 && i<N; i++, j--)
        if(board[i][j] == 1)
        return false;
    return true;
    }
    boolean solveNQ(int board[][], int col){
        if(col>=N)
        return true;
for (int i = 0; i < N; i++) {

/* Check if the queen can be placed on

board[i][col] */

if (isSafe(board, i, col)) {

/* Place this queen in board[i][col] */

board[i][col] = 1;

/* recur to place rest of the queens */

if (solveNQ(board, col + 1) == true)

return true;

/* If placing queen in board[i][col]

doesn't lead to a solution then

remove queen from board[i][col] */

board[i][col] = 0; // BACKTRACK

}

}

/* If the queen can not be placed in any row in

this column col, then return false */

return false;

}

/* This function solves the N Queen problem using

Backtracking. It mainly uses solveNQUtil () to

solve the problem. It returns false if queens

cannot be placed, otherwise, return true and

prints placement of queens in the form of 1s.

Please note that there may be more than one

solutions, this function prints one of the

feasible solutions.*/

boolean solveNQ()

{

int board[][] = { { 0, 0, 0, 0 },

{ 0, 0, 0, 0 },

{ 0, 0, 0, 0 },

{ 0, 0, 0, 0 } };

if (solveNQ(board, 0) == false) {

System.out.print("Solution does not exist");

return false;

}

printSol(board);

return true;

}

// driver program to test above function

public static void main(String args[])

{

Main Queen = new Main();

Queen.solveNQ();

}

}

