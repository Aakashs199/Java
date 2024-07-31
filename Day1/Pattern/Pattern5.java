/* 5.

    x
  x   x
x       x
x       x
  x   x  
    x      */


import java.util.*;
public class Pattern5
{
public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter the Number: ");
      int n=sc.nextInt();
      int i,j;


      for(i=1;i<=n;i++)
      {
         for(j=1;j<=n-i;j++)
          {
           System.out.print(" ");
          }
         int ind=(i+i)-1;
         for(j=1;j<=ind;j++)
          {
            if(j==1||j==ind)
               {
                 System.out.print("*");
               }
            else
               {
                 System.out.print(" ");
               }
          }
         System.out.println();
       }



      for(i=n;i>=1;i--)
      {
         for(j=1;j<=n-i;j++)
          {
           System.out.print(" ");
          }

         int ind=(i+i)-1;
         for(j=1;j<=ind;j++)
          {
            if(j==1||j==ind)
               {
                 System.out.print("*");
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