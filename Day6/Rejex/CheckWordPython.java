/* 7. Write a Java program to find the word Python in a given string, if the word Python present in the string return Java otherwise return C++. Ignore case-sensitive. */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class CheckWordPython 
  {
   public static void checkWords(String str)
   {
	Pattern pattern=Pattern.compile("\\bpython\\b",Pattern.CASE_INSENSITIVE);
	Matcher matcher=pattern.matcher(str);
	if(matcher.find())
	{
	  System.out.println("JAVA");
	}
	else
	{
	  System.out.println("C++");
	}
   }


  public static void main(String[] args)
   {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter the String: ");
      String str=sc.nextLine();
      checkWords(str);

    }
}
