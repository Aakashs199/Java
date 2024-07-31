/* 4. Longest Increasing Subsequence (LIS)

Given an array arr[] of size N, the task is to find the length of the Longest Increasing Subsequence (LIS) i.e., the longest possible subsequence in which the elements of the subsequence are sorted in increasing order.

Examples:            
Input: arr[] = {3, 10, 2, 1, 20}
Output: 3
Explanation: The longest increasing subsequence is 3, 10, 20

Input: arr[] = {3, 2}
Output:1
Explanation: The longest increasing subsequences are {3} and {2}

Input: arr[] = {50, 3, 10, 7, 40, 80}
Output: 4
Explanation: The longest increasing subsequence is {3, 7, 40, 80}

Input: arr[] = {10, 20, 35, 80}
Output: 4
Explanation: The whole array is sorted.

https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  */


import java.util.*;
public class LongestGreaterseq
{

public static int findLongest(int arr[],int n)
{
   int check[]=new int[n];
   for(int i=0;i<n;i++)
    {
      check[i]=1;
    }
  for(int i=1;i<n;i++)
   {
    for(int j=0;j<i;j++)
     {
       if( (arr[i]>arr[j]) && (check[i]<check[j]+1) )
	{
	   check[i]=check[j]+1;
	}
     }
  for(int ind=0;ind<n;ind++)
    {
     System.out.print(check[ind]+" ");
    }
   System.out.println();
   }
  int max=1;
  for(int i=0;i<n;i++)
   {
     if(max<check[i])
      {
          max=check[i];
      }
   }
 return max;
}


public static void main(String args[])
 {
  Scanner sc=new Scanner(System.in);
  int n=sc.nextInt();
  int arr[]=new int[n];
  for(int i=0;i<n;i++)
   {
    arr[i]=sc.nextInt();
   }
  System.out.print(findLongest(arr,n));
 }
}