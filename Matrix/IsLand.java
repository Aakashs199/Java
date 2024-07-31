/* 12. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.

https://leetcode.com/problems/number-of-islands/    */


import java.util.*;
public class IsLand
{
static int arr1[]={-1,0,1,0};
static int arr2[]={0,-1,0,1};
public static boolean check(int i,int j,int row,int col)
  {
     if(i<0 || j<0 || i>=row || j>=col)
        {
	    return false;
	}
	return true;
  }

public static void  checkIsland(int arr[][],int row,int col)
{
    boolean visited[][]=new boolean[row][col];
    int ans=0;
    for(int i=0;i<row;i++)
	 {
	   for(int j=0;j<col;j++)
 	    {
               if(visited[i][j]==false && arr[i][j]==1)
		{
		   ans++;
		   dfs(arr,visited,i,j,row,col);
		}
  	    }
	 }  
 	System.out.println("Number of IsLand: "+ans);
}

 public static void dfs(int arr[][],boolean visited[][],int ind1,int ind2,int row,int col)
  {
     if(!check(ind1,ind2,row,col))
	{
		return;
	}
     if(visited[ind1][ind2]==true || arr[ind1][ind2]==0)
	{
	   return;
	}
     visited[ind1][ind2]=true;
      for(int i=0;i<4;i++)
	{
	    int x=ind1+arr1[i];
	    int y=ind2+arr2[i];
	    dfs(arr,visited,x,y,row,col);
	}
  } 


 public static void main(String args[])
  {
    	Scanner sc=new Scanner(System.in);
    	System.out.print("Enter the Row: ");
    	int row=sc.nextInt();
	System.out.print("Enter the Col: ");
	int col=sc.nextInt();
	int arr[][]=new int[row][col];
	for(int i=0;i<row;i++)
	 {
	  for(int j=0;j<col;j++)
 	  {
             arr[i][j]=sc.nextInt();
  	  }
	 }
      checkIsland(arr,row,col);
  }
}