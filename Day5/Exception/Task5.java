/* (L1)Write a program to illustrate usage of try/catch with finally clause. */

import java.util.*;
public class Task5
{
 public static void main(String args[])
   {
     int n=90;
      try
      {
         int arr[]=new int[5];
         System.out.println(arr[10]);
       }
      catch(ArithmeticException e)
       {
          System.out.println("It can't Divide by 0");
       }
      catch(ArrayIndexOutOfBoundsException e)
         {
          System.out.println("Out of the Index");
         }
        catch(NullPointerException e)
         {
          System.out.println("String is Empty");
         }
   
       finally
         {
            System.out.println(n*3);
          }
        System.out.println("Last Statement will execute");
   }  
}