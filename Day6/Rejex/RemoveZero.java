/* 6.Write a Java program to remove leading zeros from a given IP address. */
/* 6.Write a Java program to remove leading zeros from a given IP address. */


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class RemoveZero 
  {

   public static String removeZero(String ip)
   {
	Pattern pattern=Pattern.compile("\\b0+(\\d+)");
	Matcher matcher=pattern.matcher(ip);
	StringBuffer ans=new StringBuffer();
	while(matcher.find())
	{
	   String replaceStr=matcher.group(1);
	    matcher.appendReplacement(ans,replaceStr); 
	}
       matcher.appendTail(ans);
  return ans.toString();
	
   }


  public static void main(String[] args)
   {
      Scanner sc=new Scanner(System.in);
      System.out.print("Enter the String: ");
      String ip=sc.nextLine();
      System.out.println(removeZero(ip));

    }
}
