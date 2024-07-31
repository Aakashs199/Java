/* 1. Arithmetic Slices: An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
Example 2:

Input: nums = [1]
Output: 0

Constraints:

1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

https://leetcode.com/problems/arithmetic-slices/   */

import java.util.*;
public class ArithmeticSlices
{
   public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       System.out.print("Enter the Number of Elements: ");
       int n=sc.nextInt();
       int arr[]=new int[n];
	for(int i=0;i<n;i++)
	  {
	     arr[i]=sc.nextInt();
	  }
     int limit=3;
     int count=0;
     for(int i=0;i<n-2;i++)
	{
	   for(int j=0;j<n-i-2;j++)
	   {
		System.out.print("[");
	     for(int k=j;k<limit+j;k++)
		{
		   System.out.print(arr[k]+" ");
		}
	      System.out.println("]");
	      count++;
	   }
	  limit++;
	
	}	
System.out.println("----->"+count);
    }
}