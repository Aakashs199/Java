/* 15. Toeplitz Matrix

Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

Example 1:

Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
Example 2:

Input: matrix = [[1,2],[2,2]]
Output: false
Explanation:
The diagonal "[1, 2]" has different elements.
 
Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 20
0 <= matrix[i][j] <= 99

Follow up:

What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
What if the matrix is so large that you can only load up a partial row into the memory at once?

https://leetcode.com/problems/toeplitz-matrix/    */


import java.util.*;
public class ToeplitzMatrix
{

public static boolean checkToeplitzMatrix(int arr[][],int row,int col)
{
   for(int i=1;i<row;i++)
    {
  	for(int j=1;j<col;j++)
	  {
		if(arr[i][j]!=arr[i-1][j-1])
		  {
			return false;
	  	  }
	  }
    }
  return true;
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
      if(checkToeplitzMatrix(arr,row,col))
	{
	   System.out.println("It is ToeplitzMatrix");
	}
      else
	{
	   System.out.println("It is Not an ToeplitzMatrix");
	}
   }
 }