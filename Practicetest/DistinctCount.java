/* 1. Given two arrays a[] and b[] of size n and m respectively. The task is to find union between these two arrays. Union of the two arrays can be defined as the set containing distinct elements from both the arrays. If there are repetitions, then only one occurrence of element should be printed in the union.
Example 1:
Input: 
5 3 
1 2 3 4 5 
1 2 3 
Output: 5 
Explanation: 1, 2, 3, 4 and 5 are the elements which comes in the union set of both arrays. So count is 5.

Example 2:
Input:
6 2 
85 25 1 32 54 6 
85 2 
Output: 7 
Explanation: 85, 25, 1, 32, 54, 6, and 2 are the elements which comes in the union set of both arrays. So count is 7.
Your Task:
Complete doUnion funciton that takes a, n, b, m as parameters and returns the count of union elements of the two arrays. The printing is done by the driver code.

Constraints:
1 ≤ n, m ≤ 10^5
0 ≤ a[i], b[i] < 10^5

Elements are not necessarily distinct.
Expected Time Complexity : O((n+m)log(n+m))
Expected Auxilliary Space : O(n+m)  */

import java.util.*;
class DistinctCount
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the Number of Elements in Array1: ");
int size1=sc.nextInt();
System.out.print("Enter the Number of Elements in Array2: ");
int size2=sc.nextInt();
int arr1[]=new int[size1];
int arr2[]=new int[size2];
for(int i=0;i<size1;i++)
 {
    arr1[i]=sc.nextInt();
 }
for(int i=0;i<size2;i++)
 {
    arr2[i]=sc.nextInt();
 }

 int[] merged = new int[size1+size2];
 for(int i=0;i<size1;i++)
  {
    merged[i]=arr1[i];
  }
 for(int i=0;i<size2;i++)
   {
     merged[size1+i]=arr2[i];
   }

Arrays.sort(merged);
int count=1;
for(int i=1;i<size1+size2;i++)
 {
    if(merged[i]!=merged[i - 1])
     {
       count++;
     }
 }

   System.out.print(count); 
}
}