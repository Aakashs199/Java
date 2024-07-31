/* 6. Climbing Stairs to reach at the top.

There are n stairs, a person standing at the bottom wants to climb stairs to reach the nth stair. The person can climb either 1 stair or 2 stairs at a time,
the task is to count the number of ways that a person can reach at the top.
Consider the example shown in the diagram. The value of n is 3. There are 3 ways to reach the top. The diagram is taken from Easier Fibonacci puzzles

Examples: 
Input: n = 1
Output: 1 There is only one way to climb 1 stair

Input: n=2
Output: 2 There are two ways: (1, 1) and (2)

Input: n = 4
Output: 5 (1, 1, 1, 1), (1, 1, 2), (2, 1, 1), (1, 2, 1), (2, 2)  */

import java.util.*;
class Stairs 
  {
    static int countWays(int n, int m)
    {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++)
        {
            dp[i] = 0;
            for(int j=1;j<=m&&j<=i;j++)
            {
                dp[i] += dp[i - j];
            }
        }
    return dp[n];
    }
public static void main(String[] args) 
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of stairs:");
    int n = scanner.nextInt();
    System.out.println("Enter the maximum number of stairs that can be climbed at a time:");
    int m = scanner.nextInt();
    System.out.println("Number of ways = " + countWays(n, m));
    }
}
