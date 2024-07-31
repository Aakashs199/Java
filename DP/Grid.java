/* 8.  Unique paths in a Grid with Obstacles

Given a grid of size m * n, let us assume you are starting at (1, 1) and your goal is to reach (m, n). At any instance, if you are on (x, y), you can either go to (x, y + 1) or (x + 1, y).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and space are marked as 1 and 0 respectively in the grid.
Examples:  

Input:
[[0, 0, 0],
[0, 1, 0],
[0, 0, 0]]

Output: 2
There is only one obstacle in the middle.
https://www.geeksforgeeks.org/unique-paths-in-a-grid-with-obstacles/  */

import java.util.*;
public class Grid 
{
    static int uniquePathsWithObstacles(int[][] A) 
    {
        int r=A.length;
        int c=A[0].length;
        int[][] paths = new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                paths[i][j] = 0;
            }
        }
       if(A[0][0]==0)
        {
           paths[0][0]=1;
        }
        for(int i=1;i<r;i++)
        {
            if(A[i][0] == 0)
                {
                  paths[i][0] = paths[i - 1][0];
                }
        }

        for(int j=1;j<c;j++)
        {
            if(A[0][j] == 0)
            {
                paths[0][j] = paths[0][j - 1];
            }
        }
        for(int i=1;i<r;i++)
        {
            for(int j=1;j<c;j++)
            {
                if(A[i][j] == 0)
                {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

    return paths[r-1][c-1];
    }

public static void main(String[] args) 
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of rows:");
    int r = scanner.nextInt();
    System.out.println("Enter the number of columns:");
    int c = scanner.nextInt();
    int[][] A = new int[r][c];
    System.out.println("Enter the matrix elements (0 for open, 1 for obstacle):");
    for(int i=0;i<r;i++)
       {
            for(int j=0;j<c;j++)
            {
                A[i][j] = scanner.nextInt();
            }
        }
    System.out.println("Number of unique paths = " + uniquePathsWithObstacles(A));
    }
}
