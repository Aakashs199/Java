/*Write a Java program to swap two variables.*/

import java.util.*;
public class Swap
{
public static void main(String args[])
{ 
  Scanner input=new Scanner(System.in);
  System.out.println("Enter the value of First value: ");
  int First=input.nextInt();
  System.out.println("Enter the value of Second value: ");
  int Second=input.nextInt();
  First=First^Second;
  Second=Second^First;
  First=First^Second;
  System.out.println("Value of First:  "+First);
  System.out.println("Value of Second:  "+Second);
   
}
}