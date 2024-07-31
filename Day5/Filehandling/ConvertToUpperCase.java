/* (L2)Write a program to accept a specified number of characters as input and converts them into uppercase characters */

import java.io.*;
public class ConvertToUpperCase
 {
    public static void main(String[] args)
 {
   try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)))
   {
          System.out.println("Enter the number of characters you want to input:");
            int numCharacters = Integer.parseInt(reader.readLine());
            System.out.println("Enter the characters:");
            char[] inputChars = new char[numCharacters];
            for (int i=0;i<numCharacters;i++)
	    {
                inputChars[i]=(char)reader.read();
            }
            String upperCaseString=new String(inputChars).toUpperCase();
            System.out.println("Uppercase characters: "+upperCaseString);
        } 
   catch(IOException e)
     {
        System.err.println("An error occurred: " + e.getMessage());
     } 
   catch(NumberFormatException e) 
    {
       System.err.println("Invalid number format: " + e.getMessage());
    }
  }
}
