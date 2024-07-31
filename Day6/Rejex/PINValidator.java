/* 10. Write a Java program to validate a personal identification number (PIN). Assume the length of a PIN is 4, 6 or 8. */

import java.util.*;
public class PINValidator 
  {
 public static boolean isValidPIN(String pin) 
    {
       if(pin==null || !(pin.length()==4||pin.length()==6||pin.length()==8)) 
	{
           return false;
        }

      for(int i=0;i<pin.length();i++)
	 {
            if(!Character.isDigit(pin.charAt(i)))
	      {
                 return false;
              }
         }

       return true;
    }


 public static void main(String[] args)
  {
      Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        if(isValidPIN(pin))
	 {
            System.out.println("PIN is valid");
         } 
	else
	 {
            System.out.println("PIN is invalid.It must be 4,6, or 8 digits long");
         }

   }
}
