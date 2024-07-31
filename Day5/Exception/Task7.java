/* (L1)Write a program for creation of user defined exception. */

import java.util.*;
 class InvalidageException extends Exception
{
     public InvalidageException(String str)
      {
        super(str);
      }
}
public class Task7
 {
     static void age(int n)throws InvalidageException
        {
           if(n<18)
            {
                throw new InvalidageException("You are under 18");
            }
            else
             {
                  System.out.println("You are elligble");
               }
        }
  public static void main(String args[])
   {
       try
        {
          age(18);
        }

        catch(InvalidageException e)
          {
             System.out.println("Invalid age");
             System.out.println(e);
          }
        System.out.println("Rest of the code");
   }
 }