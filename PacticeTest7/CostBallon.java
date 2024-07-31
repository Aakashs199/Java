/* 6. You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.

If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.

Return the maximum coins you can collect by bursting the balloons wisely.

Example 1:

Input: nums = [3,1,5,8]
Output: 167
Explanation:
nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
Example 2:

Input: nums = [1,5]
Output: 10  */
 

import java.util.*;
public class CostBallon
{
  public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the Number Elements: ");
     int n=sc.nextInt();
     int arr[]=new int[n];
     System.out.print("Enter the Elements: ");
     for(int i=0;i<n;i++)
      {
         arr[i]=sc.nextInt();
      }
    int sum=0;
    int ind=1;
    for(int i=1;i<n-1;i++)
    {
      sum+=arr[i-ind]*arr[i]*arr[i+1];
      ind++;
    }
  int first=1*arr[0]*arr[n-1];
  int last=1*arr[n-1]*1;
System.out.print(sum+first+last);
   }
}
