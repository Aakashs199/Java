/*1. Write a Java program that takes a number as input and prints its multiplication table up to 10.*/

import java.util.*;
public class Multiplication
{
public static void main(String args[])
 {
      Scanner input=new Scanner(System.in);
      System.out.println("Enter the Multiplication Table Number: ");
      int n=input.nextInt();
      System.out.println("Enter the value of last number:  ");
      int m=input.nextInt();
      for(int i=1;i<=m;i++)
         {
             System.out.println(i+"*"+n+"= "+i*n);
         }
      
 }
}