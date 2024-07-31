/* 4.
* * * * *
  * * * *
    * * *
      * *
        *   */



import java.util.*;
public class Pattern4
{
  public static void main(String args[])
    {
       Scanner sc=new Scanner(System.in);
       System.out.println("Enter the number");
       int n=sc.nextInt();
       int i,j,ind;
       for(i=1;i<=n;i++)
         {
            for(j=1;j<i;j++)
              {
                 System.out.print(" ");
              }
            ind=n-i+1;
            for(j=1;j<=ind;j++)
              {
                 System.out.print("*");   
              }
            System.out.println();
         }
    }
}