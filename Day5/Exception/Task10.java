//10.(L1)Write a program to illustrate how to throw a NumberFormatException.

import java.util.Scanner;

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.print("Enter the Value: ");
        String input = sc.next();
        try 
         {
            int number = Integer.parseInt(input);
         }
            catch (Exception e) 
         {
            System.out.println("Invalid input. Please enter a valid integer.");   
         }
       System.out.println("Continue");
    }
}
