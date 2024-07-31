/* 2. Write a Java program that matches a string that has a p followed by zero or more q's. */

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CharacterPq 
 { 

public static String validate(String text)
 {
     Pattern pattern =Pattern.compile("pq*?");
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
