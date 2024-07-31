/*  Subset Sum Problem

Given a set of non-negative integers and a value sum, the task is to check if there is a subset of the given set whose sum is equal to the given sum. 

Examples: 

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
Explanation: There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
Explanation: There is no subset that add up to 30.

https://www.geeksforgeeks.org/subset-sum-problem-dp-25/  */


import java.util.*;
public class Subset
{
  public static boolean isMatch(int arr[],int n,int target)
   {
      boolean check[][]=new boolean[target+1][n+1];
      for(int i=0;i<=n;i++)
	 {
	    check[0][i]=true; 
	 }
      for(int j=1;j<=target;j++)
	   {
	      check[j][0]=false;
	   }
    for(int i=1;i<=target;i++)
       {
	  for(int j=1;j<=n;j++)
	   {
	     check[i][j]=check[i][j-1];
	       if(i>=arr[j-1])
		{
		   check[i][j]= check[i][j] || check[i-arr[j-1]][j-1];
		}
	   }
	}
     for(int i=0;i<=target;i++)
       {
	  for(int j=0;j<=n;j++)
	   {
	    System.out.print(check[i][j]+" ");
	   }
	System.out.println();
	}
      return check[target][n];
  }

 public static void main(String args[])
 {
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the Number of Element of Array: ");
  int n=sc.nextInt();
  int arr[]=new int[n];
  for(int i=0;i<n;i++)
   {
    arr[i]=sc.nextInt();
   }
  System.out.print("Enter the Target: ");
  int target=sc.nextInt();
  System.out.print(isMatch(arr,n,target));
}
}