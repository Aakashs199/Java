/* 3. Minimum number of jumps to reach end (Jump Game)
Last Updated : 11 Jun, 2024
Given an array arr[] where each element represents the max number of steps that can be made forward from that index. The task is to find the minimum number of jumps to reach the end of the array starting from index 0.

Examples: 

Input: arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
Output: 3 (1-> 3 -> 9 -> 9)
Explanation: Jump from 1st element to 2nd element as there is only 1 step.
Now there are three options 5, 8 or 9. If 8 or 9 is chosen then the end node 9 can be reached. So 3 jumps are made.

Input:  arr[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
Output: 10
Explanation: In every step a jump is needed so the count of jumps is 10.

https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/ */

import java.util.Scanner;
class Jumps 
{
  public static int minJumps(int[] arr, int n)
    {
        int jumps[] = new int[n];
        int i,j;
        if(n==0 ||arr[0]==0)
         {
            return Integer.MAX_VALUE;
          }
        jumps[0]=0;
System.out.print(jumps[0]+" ");
        for(i=1;i<n;i++)
          {
            jumps[i]=Integer.MAX_VALUE;
            for (j=0;j<i;j++)
              {
                if(i<=j+arr[j] && jumps[j]!=Integer.MAX_VALUE)
                 {
                    jumps[i] = Math.min(jumps[i],jumps[j] + 1);
		    System.out.print(jumps[i]+" ");
                    break;
                }
            }
        }
  
     return jumps[n-1];
   }

public static void main(String[] args)
   {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i = 0; i < n; i++)
          {
            arr[i] = scanner.nextInt();
          }
        int result = minJumps(arr, n);
        if(result == Integer.MAX_VALUE)
        {
            System.out.println("End cannot be reached.");
        } 
        else
        {
          System.out.println("Minimum number is: "+result);
        }
    }
}

