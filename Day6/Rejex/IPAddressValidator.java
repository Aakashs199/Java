/* 11.Write a Java program to validate an IP address. */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class IPAddressValidator
 {
    static final String IPV4_REGEX ="^(([0-9] | [1-9][0-9] | 1[0-9][0-9] | 2[0-4][0-9] | 25[0-5])\\.){3}" +"([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])$";
    static final Pattern IPV4_PATTERN = Pattern.compile(IPV4_REGEX);

  public static boolean isValidIPAddress(String ip)
    {
        if(ip == null)
	 {
           return false;
         }

        Matcher matcher = IPV4_PATTERN.matcher(ip);
        return matcher.matches();
    }

 public static void main(String[] args)
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the IP Address: ");
   String ip=sc.nextLine();

   System.out.print(isValidIPAddress(ip));
    }
}
