/*5.Write a program to complement a given number using bitwise operator?*/

import java.util.*;
public class Complement
{
 public static void main(String args[])
 {
     Scanner input=new Scanner(System.in);
     System.out.println("Enter the First value: ");  
     int value=input.nextInt();
     System.out.println("The Complement value: "+(~value));
     
 }
}