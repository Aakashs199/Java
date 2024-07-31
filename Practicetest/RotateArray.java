/* 2.Given an array, rotate the array by one position in clock-wise direction.

Example 1:

Input:
N = 5
A[] = {1, 2, 3, 4, 5}
Output:
5 1 2 3 4

Example 2:

Input:
N = 8
A[] = {9, 8, 7, 6, 4, 2, 1, 3}
Output:
3 9 8 7 6 4 2 1

Your Task:  
You don't need to read input or print anything. Your task is to complete the function rotate() which takes the array A[] and its size N as inputs and modify the array in place.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

Constraints:
1<=N<=10^5
0<=a[i]<=10^5  */


import java.util.*;
class RotateArray
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the Number of Elements in Array: ");
  int size=sc.nextInt();
  int arr[]=new int[size];
  System.out.print("Enter the Elements: ");
  for(int i=0;i<size;i++)
  {
    arr[i]=sc.nextInt();
  }
 int first=arr[size-1];
 for(int i=size-1;i>0;i--)
 {
   arr[i]=arr[i-1];
 }
 arr[0]=first;
  for(int i=0;i<size;i++)
  {
    System.out.print(arr[i]+" ");
  }
}
}