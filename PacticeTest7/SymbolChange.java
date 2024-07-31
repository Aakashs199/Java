/* 1. You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3. */

import java.util.*;
public class SymbolChange
{
  public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the Elements: ");
     int n=sc.nextInt();
     int arr[]=new int[n];
     System.out.print("Enter the Number of Elements: ");
     for(int i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }
     System.out.print("Enter the Target: ");
     int target=sc.nextInt();
     int count=0;
    for(int i=0;i<n;i++)
     {
       int sum=0;
       arr[i]=-(arr[i]);
        for(int j=0;j<n;j++)
   	  {
            sum+=arr[j];
	  }
       if(sum==target)
        {
 	  count++;
        }
       arr[i]=-(arr[i]);
     }
   System.out.println(count);
   }
}
