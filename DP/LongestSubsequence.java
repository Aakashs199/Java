/* 5. Longest subsequence such that difference between adjacents is one

Given an array of n size, the task is to find the longest subsequence such that difference between adjacents is one. 

Examples: 
Input :  arr[] = {10, 9, 4, 5, 4, 8, 6}
Output :  3
As longest subsequences with difference 1 are, "10, 9, 8", 
"4, 5, 4" and "4, 5, 6"

Input :  arr[] = {1, 2, 3, 2, 3, 7, 2, 1}
Output :  7
As longest consecutive sequence is "1, 2, 3, 2, 3, 2, 1" */


import java.util.*;
public class LongestSubsequence
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
       if( (arr[i]==arr[j]+1) || (arr[i]==arr[j]-1) )
	{
	   check[i]=Math.max(check[i],check[j]+1);
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