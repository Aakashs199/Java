/* 2. Min Cost Path | DP-6

a. Can do using recursion
b. Can do using memoization(top-down approach & recursive call)
c. Can do using tabulation(bottom-up approach & for loop)

Given a cost matrix cost[][] and a position (M, N) in cost[][], write a function that returns cost of minimum cost path to reach (M, N) from (0, 0). Each cell of the matrix represents a cost to traverse through that cell. The total cost of a path to reach (M, N) is the sum of all the costs on that path (including both source and destination). You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed. 

Note: You may assume that all costs are positive integers.

Example:
Input:

1 2 3
4 8 2
1 5 3

The path with minimum cost is highlighted in the following figure. The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).  

Output:
_ _
1 2 \ 3
4 8  \2 
1 5  |3   */

import java.util.*;
public class MinimumCostPath 
 {
  public static int min(int x, int y, int z)
   {
        if(x<y)
          {
            return(x<z) ? x:z;
           }
        else
          {
            return (y < z) ? y:z;
          }
    }

 public static int minCostMemoized(int[][] cost, int m, int n, int[][] memo) 
    {
        if(n < 0||m<0)
          {
             return Integer.MAX_VALUE;
          }
        else if(m ==0 && n==0)
          {
             return cost[m][n];
          }

        if (memo[m][n] != -1)
         {
            return memo[m][n];
         }

        memo[m][n] =cost[m][n]+min(minCostMemoized(cost,m-1,n-1,memo),minCostMemoized(cost,m-1,n,memo),minCostMemoized(cost,m,n-1,memo));

	for(int i=0;i<3;i++) 
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(memo[i][j]+" ");
            }
	  System.out.println();
        }
	System.out.println("--------------");
        return memo[m][n];
    }

    public static int minCost(int[][] cost, int m, int n)
     {
        int[][] memo = new int[cost.length][cost[0].length];
        for (int[] row : memo)
            Arrays.fill(row, -1);
	

        return minCostMemoized(cost, m, n, memo);
    }

public static void main(String[] args) 
   {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int R = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int C = scanner.nextInt();
        int[][] cost = new int[R][C];
        System.out.println("Enter the matrix values row by row:");
        for(int i = 0; i < R; i++) 
        {
            for(int j = 0; j < C; j++)
            {
                cost[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Enter the destination row index: ");
        int m = scanner.nextInt();
        System.out.print("Enter the destination column index: ");
        int n = scanner.nextInt();
        System.out.println("The minimum cost path is: "+minCost(cost,m,n));
    }
}