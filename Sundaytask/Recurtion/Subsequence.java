/* 2. Given an array arr[] consisting of N positive integers, the task is to generate all distinct
subsequences of the array.
Examples:
Input: arr[] = {1, 2, 2}
Output: {} {1} {1, 2} {1, 2, 2} {2} {2, 2}
Explanation:
The total subsequences of the given array are {}, {1}, {2}, {2}, {1, 2}, {1, 2}, {2, 2}, {1, 2, 2}.
Since {2} and {1, 2} are repeated twice, print all the remaining subsequences of the array.
Input: arr[] = {1, 2, 3, 3}
Output: {} {1} {1, 2} {1, 2, 3} {1, 2, 3, 3} {1, 3} {1, 3, 3} {2} {2, 3} {2, 3, 3} {3} {3, 3} */


import java.util.*;
class Subsequence
{
   static StringBuilder sb = new StringBuilder();
   public static void main(String[] args){
   Scanner in = new Scanner(System.in);
   int n = in.nextInt();
   int arr[] = new int[n];
   for(int i=0;i<n;i++)
     {
     arr[i]=in.nextInt();
     }
   Arrays.sort(arr);
   subset(arr,0);
}

public static void subset(int[] arr, int idx)
  {	
      System.out.println("------------"+idx);	
      if(idx==arr.length)
        {
	  System.out.print("[");
	  for(int i=0;i<sb.length();i++)
	    {
	      System.out.print(sb.charAt(i)+",");
	    }
	 System.out.print("]");
	 System.out.println();
	 return;
	}
  sb.append(arr[idx]);
  System.out.println("**"+idx+"**");
  subset(arr,idx+1);
  sb.deleteCharAt(sb.length()-1);
  while(idx+1<arr.length && arr[idx]==arr[idx+1])
   {
    idx++;
    System.out.println("**----"+idx);
   }
  System.out.println("********"+idx);
  subset(arr,idx+1);
		
	}
}