/*5.Write a Java program to perform Shift and Bitwise operations.*/

import java.util.*;
public class Operators
{
 public static void main(String args[])
 {
     Scanner input=new Scanner(System.in);
     System.out.println("Enter the First value: ");  
     int value1=input.nextInt();
     System.out.println("Enter the Second value: ");
     int value2=input.nextInt();
     System.out.println(value1+"&"+value2+"= "+(value1&value2));
     System.out.println(value1+"|"+value2+"= "+(value1|value2));
     System.out.println(value1+"^"+value2+"= "+(value1^value2));
     System.out.println(value1+"<<"+value2+"= "+(value1<<2));
     System.out.println(value1+">>"+value2+"= "+(value1>>2));
     System.out.println(value1+">>>"+value2+"= "+(value1>>>2));
     
 
 }
}