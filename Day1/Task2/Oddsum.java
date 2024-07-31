/*3.Write a program in Java to display the n terms of odd natural number and their sum.

Input number of terms is: 5

Expected Output :
The odd numbers are
1                                                                          
3                                                                         
5                                                                          
7                                                                          
9                                                                          

The Sum of odd Natural Number up to 5 terms is: 25 */

import java.util.*;
public class Oddsum
{
public static void main(String args[])  
  {
    Scanner input=new Scanner(System.in);
    System.out.print("Enter the Number: ");
    int n=input.nextInt();
    int limit=n*2,sum=0;
    System.out.println("The Odd Numbers lies between "+n+" is: ");
    for(int i=1;i<=limit;i+=2)
     {
        System.out.println(i);
        sum+=i;
     }
     System.out.print("Sum of Odd integers= "+sum);
  }
}