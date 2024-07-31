/* 9.(L2).Given two sorted arrays A and B of size p and q, write a Java program to merge elements of A with B by maintaining the sorted order i.e. fill A with first p smallest elements and fill B with remaining elements.

Input :
int[] A = { 1, 5, 6, 7, 8, 10 }
int[] B = { 2, 4, 9 }
Output:
Sorted Arrays:
A: [1, 2, 4, 5, 6, 7]
B: [8, 9, 10]  */


import java.util.*;
public class Twosort
{
 public static void main(String args[])
  {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the size of the first array: ");
    int p = scanner.nextInt();
    int[] a = new int[p];
    System.out.println("Enter the elements of the first array:");
    for(int i=0;i<p;i++)
      {
         a[i]=scanner.nextInt();
      }

    System.out.print("Enter the size of the second array: ");
    int q = scanner.nextInt();
    int[] b = new int[q];
    System.out.println("Enter the elements of the second array:");
    for(int i=0;i<q;i++) 
	{
          b[i]=scanner.nextInt();
        }
    int i,j,temp,start;
     for(i=0;i<p;i++)
         { 
            if(a[i]>b[0])
            {
            temp=a[i];
            a[i]=b[0];
            b[0]=temp;

             start=b[0];
             for(j=1;j<q&&b[j]<start;j++)
             { 
                    b[j-1]=b[j];
              } 
              b[j-1]=start;
            }
             
           }

      for(i=0;i<p;i++)
       {
        System.out.print(a[i]+" ");
       }
        System.out.println();
       for(i=0;i<q;i++)
       {
        System.out.print(b[i]+" ");
       }

  }
}