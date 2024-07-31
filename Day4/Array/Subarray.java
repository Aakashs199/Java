/* 8(L3).Write a Java program to check if a sub-array is formed by consecutive integers from a given array of integers.

Input :
nums = { 2, 5, 0, 2, 1, 4, 3, 6, 1, 0 }

Output:
The largest sub-array is [1, 7]

Elements of the sub-array: 5 0 2 1 4 3 6  */


import java.lang.*;
public class Subarray
 {
  public static void main (String[] args)
   {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n=scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for(int i=0;i<n;i++) 
	{
            arr[i] = scanner.nextInt();
        }
        int len=1;
        int start=0,end=0;

    for(int i=0;i<n-1;i++)
        {
         int  min_val=arr[i];
         int  max_val=arr[i];

         for(int j=i+1;j<n;j++)
           {
              min_val = Math.min(min_val, A[j]);
              max_val = Math.max(max_val, A[j]);
              if(isConsecutive(A, i, j, min_val, max_val))
              {
                 if(len<max_val-min_val+1)
                   {
                     len = max_val-min_val+1;
                     start=i;
                     end=j;
                   }
            }
         }
      }

      System.out.println("The largest subarray is from index ["+start + "," + end + "]");
      System.out.print("The elements of subarray are: ");
      for (int x = start; x <= end; x++)
           {
         System.out.print(A[x]+" ");
           }
   }

   private static boolean isConsecutive(int[] A, int i, int j, int min, int max) 
     {
        if (max - min != j - i)
          {
             return false;
          }
      boolean visited[] = new boolean[j - i + 1];    
      for (int k = i; k <= j; k++)
           {
            if (visited[A[k] - min]) 
              {
              return false;
              }
         visited[A[k] - min] = true;
           }
      return true;
   }
}