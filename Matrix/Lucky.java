/* 1. Given an m x n matrix of distinct numbers, return all lucky numbers in the matrix in any order.

A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 2:

Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
Output: [12]
Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
Example 3:

Input: matrix = [[7,8],[1,2]]
Output: [7]
Explanation: 7 is the only lucky number since it is the minimum in its row and the maximum in its column.
 

Constraints:

m == mat.length
n == mat[i].length
1 <= n, m <= 50
1 <= matrix[i][j] <= 10^5.
All elements in the matrix are distinct.    */

import java.util.*;
public class Lucky
{


public static boolean isLucky(int arr[][],int row,int col,int i,int j,int value)
{
 int min=Integer.MAX_VALUE;
 int max=Integer.MIN_VALUE;
 for(int ind=0;ind<col;ind++)
  {
     if(arr[i][ind]<min)
	{
	   min=arr[i][ind];
	}
  }

  for(int ind=0;ind<row;ind++)
  {
     if(arr[ind][j]>max)
	{
	    max=arr[ind][j];
	}
  }
     

   if(value==min && value==max)
	{
	   return true;
	}
   else
	{
	   return false;
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
       if(isLucky(arr,row,col,i,j,arr[i][j]))
	{
	   System.out.println(arr[i][j]);
	}
   }
 }


}
}
