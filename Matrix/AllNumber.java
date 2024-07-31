/* 25. Check if Every Row and Column Contains All Numbers

An n x n matrix is valid if every row and every column contains all the integers from 1 to n (inclusive).

Given an n x n integer matrix matrix, return true if the matrix is valid. Otherwise, return false.

Example 1:

Input: matrix = [[1,2,3],[3,1,2],[2,3,1]]
Output: true
Explanation: In this case, n = 3, and every row and column contains the numbers 1, 2, and 3.
Hence, we return true.

Example 2:

Input: matrix = [[1,1,1],[1,2,3],[1,2,3]]
Output: false
Explanation: In this case, n = 3, but the first row and the first column do not contain the numbers 2 or 3.
Hence, we return false.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
1 <= matrix[i][j] <= n    */

import java.util.*;
public class AllNumber
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Row: ");
int n=sc.nextInt();
int arr[][]=new int[n][n];
for(int i=0;i<n;i++)
 {
  for(int j=0;j<n;j++)
   {
      arr[i][j]=sc.nextInt();
   }
 }

int sum=n*(n+1);
sum/=2;
int flag=0;
for(int i=0;i<n;i++)
 {
   int rowSum=0;
   int colSum=0;
  for(int j=0;j<n;j++)
   {
      rowSum+=arr[i][j];
      colSum+=arr[j][i];
   }
   if(rowSum!=sum || colSum!=sum)
	{
 	    flag=1;
	    break;
	}
 }
if(flag==0)
{
System.out.println("TRUE");
}
else
{
System.out.println("FALSE");
}

}
}