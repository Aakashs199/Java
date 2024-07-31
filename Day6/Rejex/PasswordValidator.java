/* 10.Write a Java program to validate a password. */

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
public class PasswordValidator 
{
    static final String PASSWORD_REGEX = "^(?=.*[A-Z]) (?=.*[a-z]) (?=.*\\d) (?=.*[@$!%*?&]) [A-Za-z\\d@$!%*?&]{8,}$";
    static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public static boolean isValidPassword(String password) 
      {
        if(password == null)
	 {
            return false;
         }
        Matcher matcher = PASSWORD_PATTERN.matcher(password);
        return matcher.matches();
    }

public static void main(String[] args)
  {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password It must be at least 8 characters,one uppercase letter,one lowercase letter,one digit and one special character: ");
        String password = scanner.nextLine();
        if(isValidPassword(password)) 
	  {
            System.out.println("Password is valid.");
          }
	 else 
	  {
            System.out.println("Password is invalid");
          }
    }
}
