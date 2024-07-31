/* 9. Given N items where each item has some weight and profit associated with it and also given a bag with capacity W, [i.e., the bag can hold at most W weight in it]. 
The task is to put the items into the bag such that the sum of profits associated with them is the maximum possible. 
Note: The constraint here is we can either put an item completely into the bag or cannot put it at all [It is not possible to put a part of an item into the bag].

Examples:

Input: N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
Output: 3
Explanation: There are two items which have weight less than or equal to 4. If we select the item with weight 4, the possible profit is 1. And if we select the item with weight 1, the possible profit is 3. So the maximum possible profit is 3. Note that we cannot put both the items with weight 4 and 1 together as the capacity of the bag is 4.

Input: N = 3, W = 3, profit[] = {1, 2, 3}, weight[] = {4, 5, 6}
Output: 0

https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/  */

import java.util.*;
class Knapsack 
{
    static int max(int a, int b) 
    {
        return (a > b) ? a : b;
    }
    static int knapSack(int W, int wt[], int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];
        for(i=0;i<=n;i++)
        {
            for(w = 0; w <= W; w++)
            {
                if (i == 0 || w == 0)
                {
                    K[i][w] = 0;
                }
                else if (wt[i - 1] <= w)
                {
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                }
                else
                {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

    return K[n][W];
    }
public static void main(String args[])
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the number of items:");
    int n = scanner.nextInt();
    int[] profit = new int[n];
    int[] weight = new int[n];
    System.out.println("Enter the profit values of the items:");
    for(int i=0;i<n;i++)
      {
        profit[i] = scanner.nextInt();
      }
    System.out.println("Enter the weight values of the items:");
    for(int i=0;i<n;i++) 
        {
            weight[i] = scanner.nextInt();
        }
    System.out.println("Enter the capacity of the knapsack:");
    int W = scanner.nextInt();
    System.out.println("Maximum profit that can be obtained: " + knapSack(W, weight, profit, n));
    }
}

