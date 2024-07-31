/*5. Write a Java program that matches a word containing 'g', not at the start or end of the word.
 Write a Java program to match a string that contains only upper and lowercase letters, numbers, and underscores. */

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class ContainsLetterG 
 { 

public static String validate(String text)
 {
     Pattern pattern =Pattern.compile("\\Bg\\B");
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
