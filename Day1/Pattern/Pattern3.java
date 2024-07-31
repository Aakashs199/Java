/* 3. 
x       x
  x   x  
    x
  x   x
x       x  */

import java.util.*;
public class Pattern3
{
public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter the Number: ");
      int n=sc.nextInt();
      int i,j;
      for(i=0;i<n;i++)
      {
         for(j=0;j<n;j++)
          {
            
            if(i==j||j==n-i-1)
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