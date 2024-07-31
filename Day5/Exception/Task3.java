/* 3.(L1)Write a program to illustrate how to use multiple catch statements. */

import java.util.*;
public class Task3
{
 public static void main(String args[])
   {
      int n=60;
      try
      {
         int ans=n/0;
      }
      catch(ArrayIndexOutOfBoundsException e)
      {
          System.out.println(e);
      }
      catch(ArithmeticException e)
       {
        System.out.println(e); 
       }
      catch(Exception e)
       {
          System.out.println(e);
        }
     System.out.println(n/2);
   }  
}