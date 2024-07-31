/*1.

* * * * *
  *       *
    *   *
      *
    *   *
  *       *
* * * * *     */


import java.util.*;
public class Pattern1
{
  public static void main(String args[])
   {
         Scanner sc=new Scanner(System.in);
         System.out.print("Enter the Number: ");
         int n=sc.nextInt();
         int i,j;
         for(i=1;i<=n;i++)
           {
            System.out.print("* ");    
           }
            System.out.println(); 
          
           for(i=1;i<=n;i++)
           {
            System.out.print("  ");
              for(j=1;j<=n;j++)
              {
                  if(i==j||j==n-i+1)
                   {
                      System.out.print("* ");
                   }
                   else
                   {
                      System.out.print("  ");
                   }
              }   
             System.out.println(); 
           }

         for(i=1;i<=n;i++)
           {
            System.out.print("* ");    
           }
    }
}