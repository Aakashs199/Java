/* 1.1(L1).Write a Java program to sort a numeric array and a string array. */

import java.util.*;
public class Sorting
{
public static void Bubble(int arr[],int n)
   { 
       int i,j,temp,k;
       for(i=0;i<n-1;i++)
       {
         for(j=0;j<n-i-1;j++)
          {
             if(arr[j]>arr[j+1])
               {
                   temp=arr[j+1];
                   arr[j+1]=arr[j];
                   arr[j]=temp;
               }
          }
       }         
   }
public static void BubbleWords(String arr[],int m)
   { 
       int i,j;
       for(i=0;i<m-1;i++)
       {
         for(j=0;j<m-i-1;j++)
          {
             if(arr[j].compareTo(arr[j+1])>0)
               {
                   String temp=arr[j+1];
                   arr[j+1]=arr[j];
                   arr[j]=temp;
               }
          }
       }         
   }

public static void main(String args[])
  {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the number of element:");
     int n=sc.nextInt();
     int i;
     int arr[]=new int[n];
     System.out.println("Enter the elements in array");
     for(i=0;i<n;i++)
       {
          arr[i]=sc.nextInt();
       }
   
     System.out.print("Enter the number of element in String  Array:");
     int m=sc.nextInt();
     sc.nextLine();
     String arr1[]=new String[m];
     System.out.println("Enter the String in array");
     for(i=0;i<m;i++)
       {
          arr1[i]=sc.nextLine();
       }
     Bubble(arr,n);
     BubbleWords(arr1,m);
     System.out.println("Sorted Integer Array is: ");
     for(i=0;i<n;i++)
       {
        System.out.print(arr[i]+" ");
       }
    System.out.println();
    System.out.println("---------------------");
    System.out.println("Sorted String Array is: ");
     for(i=0;i<m;i++)
       {
        System.out.print(arr1[i]+" ");
       }



  } 
}