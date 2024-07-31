/* 4. Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:

Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2. */

import java.util.*;
public class CircularRotate
 {
  public static void main(String[] args)
   {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the Number of Elements: ");
     int n=sc.nextInt();
     int nums[]=new int[n];
     System.out.print("Enter the Elements: ");
     for(int i=0;i<n;i++)
      {
         nums[i]=sc.nextInt();
      }
     int[] result = new int[n];
     Arrays.fill(result, -1);
     int[] arr = new int[n];
     int top=-1;

     for(int i=0;i<n*2;i++)
	 {
            int num=nums[i % n];
            System.out.println("Num: "+num);
             while(top != -1 && nums[arr[top]]<num)
	      {
                result[arr[top--]] = num;
               System.out.println("*******");
              }
          
            if(i<n)
            {
   		System.out.println("i: "+i);
                arr[++top]=i;

            }
	 System.out.println("Arr: " + Arrays.toString(arr));
	 System.out.println("Result: " + Arrays.toString(result));
        }

    System.out.println("Output: " + Arrays.toString(result));
    }
}
