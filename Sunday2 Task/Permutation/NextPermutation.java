/* 2. Next Permutation(Medium)
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the
permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array
is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the
lowest possible order (i.e., sorted in ascending order).
For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums. The replacement must be in place and use only constant extra
memory.
Examples:
Input: nums = [1,2,3]
Output: [1,3,2]
Input: nums = [3,2,1]
Output: [1,2,3]
Input: nums = [1,1,5]
Output: [1,5,1]
Constraints:
1 <= nums.length <= 100
0 <= nums[i] <= 100   */

import java.util.*;
public class NextPermutation
 {
    public static void nextPermutation(int[] arr) 
     {
        int i=arr.length-2;
        while(i>=0&&arr[i]>=arr[i + 1])   //find Pivot from rigth long  array
	 {
            i--;
         }

        if(i>=0)
	 {
            int j=arr.length - 1;
            while(arr[j]<=arr[i])     // find next great if pivot
	     {
                j--;
             }
            swap(arr,i,j);
        }
        reverse(arr,i+1);
    }

  private static void swap(int[] arr,int i,int j)
    {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
    }

 private static void reverse(int[] arr,int start)
 {
    int i=start;
    int j=arr.length-1;
    while(i<j)
      {
         swap(arr,i,j);
         i++;
         j--;
      }
  }

 public static void main(String[] args)
 {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the Number of Elements in Array: ");
    int n=sc.nextInt();
    System.out.println("Enter the Elements: ");
    int[] arr=new int[n];
    for(int i=0;i<n;i++)
       {
   	  arr[i]=sc.nextInt();
       }
    nextPermutation(arr);
    System.out.println(Arrays.toString(arr));
    }
}
