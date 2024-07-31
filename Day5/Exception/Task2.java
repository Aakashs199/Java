/* 2. (L1)Write a program using try and catch block where check whether the given array size is negative or not. */

import java.util.*;
public class Task2
{
 public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      try
         {
	   System.out.print("Enter the Size of Array: ");
           int n=sc.nextInt();
           int arr[]=new int[n];
           arr[10]=9;
           System.out.println(arr[10]);
         }
       catch(Exception e)
         {
            System.out.println(e);
         }
      System.out.println("Rest of operation");
   }  
}