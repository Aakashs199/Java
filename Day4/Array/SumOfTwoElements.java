/* 3(L2).Write a Java program to find the sum of the two elements of a given array which is equal to a given integer.

Sample array: [1,2,4,5,6]

Target value: 6.  */

import java.util.Scanner;
public class SumOfTwoElements
 {
    public static void main(String[] args)
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
     System.out.print("Enter the target sum: ");
     int target=scanner.nextInt();
     findPairs(arr, target);
    }

 public static void findPairs(int[] arr, int target) 
   {
      boolean found = false;
      for(int i=0;i<arr.length;i++) 
	{
          for(int j=i+1;j<arr.length;j++)
	    {
                if(arr[i]+arr[j] == target)
		 {
                    System.out.println("Pair found: (" + arr[i] + ", " + arr[j] + ")");
                    found = true;
                }
            }
        }
        if(!found)
	 {
            System.out.println("No pair found with the given target sum.");
         }
    }
}
