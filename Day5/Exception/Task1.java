/* (L1)Write a program to illustrate how to throw an exception */

import java.util.*;
public class Task1
{
 public static void main(String args[])
   {
      int n=60;
      try
      {
         int ans=n/0;
      }
      catch(ArithmeticException e)
       {
        System.out.println(e); 
       }
     System.out.println(n);
   }  
}