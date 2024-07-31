/*4.Two numbers are entered through the keyboard. Write a program to find the value of one number raised to the power of another. (Do not use Java built-in method).*/

import java.util.*;
public class Power
{
   public static void main(String args[])
  {
     Scanner input=new Scanner(System.in);
     System.out.print("Enter the base value: ");
     int base=input.nextInt();
     System.out.print("Enter the Power value: ");
     int power=input.nextInt();
     int multi=1;
     while(power>0)
        {
            multi*=base; 
            power--;
        }
   
     System.out.print(multi);
  } 
}