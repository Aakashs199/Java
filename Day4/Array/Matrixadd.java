/* 2.2(L1).Write a Java program to add two matrices of the same size. */

import java.util.*;
public class Matrixadd
{
  public static void main(String args[])
   {
      Scanner sc=new Scanner(System.in);
      int n=3,m=3,i,j;
      int a[][]={{1,2,3},{4,5,6},{7,8,9}};
      int b[][]={{1,2,3},{4,5,6},{7,8,9}};
      int c[][]=new int[3][3];
      for(i=0;i<n;i++)
       {
         for(j=0;j<m;j++)
           {
              c[i][j]=a[i][j]+b[i][j];
           }
       }
      for(i=0;i<n;i++)
       {
         for(j=0;j<m;j++)
           {
              System.out.print(c[i][j]+" ");
           }
           System.out.println();
       }
   }
}