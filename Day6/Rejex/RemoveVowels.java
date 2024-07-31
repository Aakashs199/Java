/* 8. Write a Java program to remove all the vowels of a given string. Return the new string. */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class RemoveVowels 
  {
   public static String removeVowels(String str)
   {
	Pattern pattern=Pattern.compile("[aeiouAEIOU]");
	Matcher matcher=pattern.matcher(str);
	StringBuffer ans=new StringBuffer();
	while(matcher.find())
	{
	  matcher.appendReplacement(ans,"");
	}
	matcher.appendTail(ans);

	return ans.toString();
   }


  public static void main(String[] args)
   {
      Scanner sc=new Scanner(System.in);
      String str=sc.nextLine();
      String result=removeVowels(str);
      System.out.println("Original string: "+str);
      System.out.println("String without vowels: "+result);
    }
}
