/* 7. Cutting a Rod | DP-13
 
Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n. Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, if the length of the rod is 8 and the values of different pieces are given as the following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6) 

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as follows, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1) 

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20

https://www.geeksforgeeks.org/cutting-a-rod-dp-13/  */

import java.util.*;
class Rod 
{
  public static int cutRod(int price[], int index, int n, int[][] dp)
    {
      if(index == 0)
        {
            return n*price[0];
        }

        if (dp[index][n] != -1)
        {
            return dp[index][n];
        }
        int notCut = cutRod(price, index - 1, n, dp);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;
        if (rod_length <= n) 
        {
            cut = price[index] + cutRod(price, index, n - rod_length, dp);
        }
        return dp[index][n] = Math.max(cut, notCut);
    }
public static void main(String[] args)
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of different piece lengths:");
    int size = scanner.nextInt();
    int arr[] = new int[size];
    System.out.println("Enter the prices of the different pieces:");
    for(int i = 0; i < size; i++) 
        {
            arr[i] = scanner.nextInt();
        }
    System.out.println("Enter the total length of the rod:");
    int n = scanner.nextInt();
    int dp[][] = new int[size][n + 1];
        for(int i = 0; i < size; i++) 
        {
            Arrays.fill(dp[i], -1);
        }
        System.out.println("Maximum Obtainable Value is " + cutRod(arr, size - 1, n, dp));
    }
}
