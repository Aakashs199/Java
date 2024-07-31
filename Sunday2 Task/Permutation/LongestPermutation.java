/* 10. Given an array A consisting of N positive integers, find the total number of subsequences of the given array such that the chosen
subsequence represents a permutation.
Note: Sequence A is a subsequence of B if A can be obtained from B by deleting some(possibly, zero) elements without changing its
order. For example, [3,1] is a subsequence of [3,2,1] and [4,3,1], but not a subsequence of [1,3,3,7] and [3,10,4].
Two permutations are different if they are of different lengths or if there is any element in the two permutations such that its index in
the original array is different.
A permutation of length N is an array of length N in which every element from 1 to N occurs exactly once.
Examples:
Input: N = 5, A[] = {1, 2, 3, 2, 4}
Output: 7
Explanation: We can get 7 permutations: {1}, {1, 2}, {1, 2}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3, 4}, {1, 2, 3, 4}.
Input: N = 4, A[] = {2, 1, 1, 2}
Output: 6
Explanation: We can get 6 permutations: {1}, {1}, {2, 1}, {2, 1}, {1, 2}, {1, 2}  */

import java.util.*;
public class LongestPermutation
{
public static void main(String[] args)
  {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Value of N: ");
   int n=sc.nextInt();
   System.out.println("Enter the Elements: ");
   int[] arr=new int[n];
    int[] freq = new int[n+1];
    for(int i=0;i<n;i++)
      {
   	arr[i]=sc.nextInt();
      }

  for(int ele : arr)
   {
      freq[ele]++;
   }
  
  long prev = 1;
  long ans = 0;
  for(int i=1;i<=n;i++)
    {
      if(freq[i]>0)
        {
           prev *= freq[i];
           ans += prev;
         }
    }
        System.out.println("Maximum combination: "+ans);
    }
}
