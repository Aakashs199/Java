/*2.Write a Java program that reads a floating-point number and prints "zero" if the number is zero. Otherwise, print "positive" or "negative". Add "small" if the absolute value of the number is less than 1, or "large" if it exceeds 1,000,000.*/

import java.util.*;
public class Floatnum
{
   public static void main(String args[])
  {
     Scanner input=new Scanner(System.in);
     System.out.print("Enter the Value: ");
     float n=input.nextFloat();
     if(n==0.0)
     {
        System.out.println("Zero");
     }
     else if(n>0.0)
      {
         System.out.println("Positive");
      }
      else
       {
           System.out.println("Negative");
       }
      if(n<1.0)
        {
            System.out.println("Small");
        }
       else if(n>1000000.0)
          {
               System.out.println("Large");
          }
  }
}