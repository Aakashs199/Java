/* 9. Write a Java program to count the number of decimal places in a given number */

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DicimalPlaceCounter
 {
public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in);
     double value=sc.nextDouble();
     String number=Double.toString(Math.abs(value));
     Pattern pattern=Pattern.compile("\\.\\d+");
     Matcher matcher=pattern.matcher(number);

     int decipoint=0;
     while(matcher.find())
	{
	   decipoint++;
	}
	System.out.println("The Number of Decimal Pointer is: "+decipoint);
   }
 }