/* 3. Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

Example 1:
Input:
nums = [-1,2,1,-4], target = 1

Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:
Input:
nums = [0,0,0], target = 1
Output: 0

Constraints:

3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-10^4 <= target <= 10^4  */


import java.util.*;
public class CloseTarget
 {
   static int nearTarget(int sum, int target)
    {
      if(sum>0) 
	{
          return Math.abs(sum - target);
        }
	 else
 	{
          int count = 0;
          while(sum != target)
 	    {
              count++;
              sum++;
            }
            return count;
        }
    }

  public static void main(String args[]) 
{
     Scanner sc = new Scanner(System.in);
     System.out.print("Enter the Number of Elements: ");
     int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) 
          {
            arr[i] = sc.nextInt();
        }
      System.out.print("Enter the Target Element: ");
      int target=sc.nextInt();
      int min=Integer.MAX_VALUE;
      int ans=0;
      for(int i=0;i<n-2;i++)
        {
          int sum=0;
            for (int j=i;j<=i+2;j++)
             {
                sum += arr[j];
             }
           int value = nearTarget(sum, target);
           if (value<min)
             {
                min = value;
                ans = sum;
             }
        }
        System.out.print("Nearest Target is: " + ans);
    }
}

