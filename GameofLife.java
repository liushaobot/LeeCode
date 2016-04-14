/*
According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the
 following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. 
How would you address these problems?
*/

public class Solution {
    public void gameOfLife(int[][] board) {
        int rows=board.length;
        int cols=board[0].length;
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                int neighbors = getNeighbour(board, i, j);
                if(board[i][j]==1){
                    if(neighbors==2 || neighbors==3)
                        board[i][j]=3;
                }else{
                    if(neighbors==3)
                        board[i][j]=2;
                }
            }
        }    
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                board[i][j]>>=1;
            }
        }
    }

    private int getNeighbour(int[][] board, int row, int col){
        int cnt=0;
        for(int i=row-1;i<=row+1;++i){
            for(int j=col-1;j<=col+1;++j){
                if(i>=0 && i<board.length && j>=0 && j<board[0].length){
                    cnt += board[i][j]&1;
                }
            }
        }
        cnt-=board[row][col]&1;
        return cnt;
    }
}