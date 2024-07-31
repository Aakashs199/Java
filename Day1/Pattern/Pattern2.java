/* 2.

w           w
w           w
w     w     w
w   w   w   w
w w       w w
w           w  */


import java.util.*;
public class Pattern2
{
public static void main(String args[])
  { 
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the Number: ");
     int n=sc.nextInt();
      int i,j;
     int m=(n%2==0)?n+1:n;
      for(i=0;i<n;i++)
      {
         for(j=0;j<m;j++)
          {
            if(j==0||j==m-1)
               {
                 System.out.print("W");
               }
            else if(i==j&&i>=m/2)
             {
              System.out.print("W"); 
             }
            else if(j==m-i-1&&i>=m/2)
             {
              System.out.print("W");
             }
            else
               {
                System.out.print(" ");
                }

          } 
           System.out.println();
     }
      
  }
}