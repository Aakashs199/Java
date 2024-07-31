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
public class TargetSumnew
 {
  private static int findWays(int[] nums, int index, int sum, int target)
    {
    if(index==nums.length)
     {
       if(sum==target)
           return 1;
       else
           return 0;
     }
    int positiveWays=findWays(nums,index+1,sum+nums[index],target);
    int negativeWays=findWays(nums,index+1,sum-nums[index],target);

        return positiveWays + negativeWays;
    }

public static void main(String[] args)
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
     int ways = findWays(arr,0,0,target);
     System.out.println("Number of ways to assign symbols: " + ways);
    }
}
