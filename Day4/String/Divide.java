/* 6(L2).Write a Java program to divide a string into n equal parts.  */

import java.util.*;
public class Divide
{
   public static void main(String args[])
    {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the String: ");
     String str=sc.nextLine();
     System.out.print("Enter the value of N to break the String: ");
     int n=sc.nextInt();
     int len=str.length();
     if(len%n!=0)
      {
       System.out.println("Not valid");
      }
      else
      {
        for(int i=0;i<len;i++)
          {
             if(i%n==0)
               {
                  System.out.println();
               }
             System.out.print(str.charAt(i));
          }
       }
    }
}