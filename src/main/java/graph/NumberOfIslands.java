//Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island. From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
//
//        More formally, from any cell (i, j) if A[i][j] = 1 you can visit:
//
//        (i-1, j) if (i-1, j) is inside the matrix and A[i-1][j] = 1.
//        (i, j-1) if (i, j-1) is inside the matrix and A[i][j-1] = 1.
//        (i+1, j) if (i+1, j) is inside the matrix and A[i+1][j] = 1.
//        (i, j+1) if (i, j+1) is inside the matrix and A[i][j+1] = 1.
//        (i-1, j-1) if (i-1, j-1) is inside the matrix and A[i-1][j-1] = 1.
//        (i+1, j+1) if (i+1, j+1) is inside the matrix and A[i+1][j+1] = 1.
//        (i-1, j+1) if (i-1, j+1) is inside the matrix and A[i-1][j+1] = 1.
//        (i+1, j-1) if (i+1, j-1) is inside the matrix and A[i+1][j-1] = 1.
//        Return the number of islands.
//
//        NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.

package graph;

public class NumberOfIslands {
    public int solve(int[][] A) {

        int count=0;
        int row[]={0,1,1,0,-1,-1,-1,1};
        int col[]={1,0,1,-1,1,0,-1,-1};
        for(int i=0;i<A.length;i++){
            for(int j=0;j<A[0].length;j++){
                if(A[i][j]==1){
                    count++;
                    traverse(A,i,j);

                }
            }
        }

        return count;
    }

    public void traverse(int[][] A,int x,int y){
        if(x == A.length || x<0) return;
        if(y == A[0].length || y<0) return;

        if(A[x][y]==0) return;

        int row[]={0,1,1,0,-1,-1,-1,1};
        int col[]={1,0,1,-1,1,0,-1,-1};
        A[x][y]=0;
        for(int k=0;k<row.length;k++)
            traverse(A, x+row[k],y+col[k]);
    }
}