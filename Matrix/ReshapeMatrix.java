/* 20. Reshape the Matrix

In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.

You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.

The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.

If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.

Example 1:

Input: mat = [[1,2],[3,4]], r = 1, c = 4
Output: [[1,2,3,4]]

Example 2:

Input: mat = [[1,2],[3,4]], r = 2, c = 4
Output: [[1,2],[3,4]]

Constraints:

m == mat.length
n == mat[i].length
1 <= m, n <= 100
-1000 <= mat[i][j] <= 1000
1 <= r, c <= 300    */


import java.util.*;
public class ReshapeMatrix
{
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

	System.out.print("Enter the Value of R: ");
    	int r=sc.nextInt();
	System.out.print("Enter the Value of C: ");
	int c=sc.nextInt();
	int ans[][]=new int[r][c];


	if(r*c!=row*col)
	{
	  for(int i=0;i<row;i++)
	    {
	      for(int j=0;j<col;j++)
 	       {
                 System.out.print(arr[i][j]+" ");
  	       }
	    System.out.println();
	 }
	   System.out.println("Reshape is Not Possible");
	   return;
	}

	 for(int i=0;i<row*col;i++)
	 {
             ans[i/c][i%c] = arr[i/col][i%col];
         }


	for(int i=0;i<r;i++)
	 {
	  for(int j=0;j<c;j++)
 	  {
             System.out.print(ans[i][j]+" ");
  	  }
	    System.out.println();
	 }
      
}
}