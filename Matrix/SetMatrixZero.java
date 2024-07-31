/* ==================================================================================
6. Set Matrix Zeroes

Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.

Example 1:

 +---+---+---+     +---+---+---+
 | 1 | 1 | 1 |     | 1 | 0 | 1 |    
 +---+---+---+     +---+---+---+
 | 1 | 0 | 1 | --> | 0 | 0 | 0 |  
 +---+---+---+     +---+---+---+
 | 1 | 1 | 1 |     | 1 | 0 | 1 |
 +---+---+---+     +---+---+---+

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

 +---+---+---+---+     +---+---+---+---+
 | 0 | 1 | 2 | 0 |     | 0 | 0 | 0 | 0 |    
 +---+---+---+---+     +---+---+---+---+  
 | 3 | 4 | 5 | 2 | --> | 0 | 4 | 5 | 0 |
 +---+---+---+---+     +---+---+---+---+ 
 | 1 | 3 | 1 | 5 |     | 0 | 3 | 1 | 0 |
 +---+---+---+---+     +---+---+---+---+ 

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-2^31 <= matrix[i][j] <= 2^31 - 1

https://leetcode.com/problems/set-matrix-zeroes/   */


import java.util.*;
public class SetMatrixZero
{
public static void setZeroMatrix(int arr[][],int i,int j,int row,int col)
  {
       for(int ind=0;ind<col;ind++)
	{
	    if(arr[i][ind]!=0)
	    {
	      arr[i][ind]=-1;
	    }
	}
	for(int ind=0;ind<row;ind++)
	{
	    if(arr[ind][j]!=0)
	      {
	         arr[ind][j]=-1;
	      }
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


	for(int i=0;i<row;i++)
 	{
  	  for(int j=0;j<col;j++)
   	    {
                 if(arr[i][j]==0)
		   {
			setZeroMatrix(arr,i,j,row,col);
		   }      
   	    }
 	}

   for(int i=0;i<row;i++)
 	{
  	  for(int j=0;j<col;j++)
   	    {
	        if(arr[i][j]==-1)
		{
		   arr[i][j]=0;
		}
                 System.out.print(arr[i][j]+" ");   
   	    }
	   System.out.println();
 	}


}
}