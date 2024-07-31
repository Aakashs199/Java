/* 10.10(L1). Write a Java program to form the largest number from a given list of non negative integers. 

Example:
Input :
nums = {1, 2, 3, 0, 4, 6}
Output:
Largest number using the said array numbers: 643210  */

import java.util.*;
public class Largest
{
public static void insert(int arr[],int n)
   { 
      int i,j,k;
      for(i=1;i<n;i++)
     {
        j=i-1;
        int temp=arr[i];
        while(j>=0&&temp<arr[j])
             { 
                arr[j+1]=arr[j];
                j--;
             } 
         arr[j+1]=temp;  
     }
   }

  public static void main(String args[])
   {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the Value of N: ");
    int n=sc.nextInt();
    int arr[]=new int[n];
    System.out.println("Enter the Values");
    for(int i=0;i<n;i++)
     {
       arr[i]=sc.nextInt();
     }
    insert(arr,n);
    int rem,sum=0;
     for(int i=n-1;i>=0;i--)
     {
        sum=sum*10+arr[i];  
     }
     System.out.print("Lorgest Combination is: "sum);
   }
}