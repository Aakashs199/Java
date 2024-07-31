/*1. Write a Java program to check whether a string contains only a certain set of characters (in this case a-z, A-Z and 0-9). */

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CharacterSet 
 { 

public static String validate(String text)
 {
     Pattern pattern =Pattern.compile("^[\\w]+$");
     Matcher matcher=pattern.matcher(text);

     if(matcher.find())
      {
         return "Found a match!";
      }
     else
      {
         return "Not matched!";
      }
   }
   public static void main(String[] args) 
  {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number of Words: ");
   int n=sc.nextInt();
   sc.nextLine();
   String arr[]=new String[n];
   for(int i=0;i<n;i++)
    {
      arr[i]=sc.nextLine();
    }
  for(int i=0;i<n;i++)
    {
      System.out.println(validate(arr[i]));
    }	   
	    	
  }

   
}
