/*1.Write a Java program to solve quadratic equations (use if, else if and else).*/

import java.util.*;
public class Quadratic
{
   public static void main(String args[])
  {
     Scanner input=new Scanner(System.in);
     System.out.println("Enter the  Co-efficient od X^2: ");
     double a=input.nextDouble();
     System.out.println("Enter the  Co-efficient of X: ");
     double b=input.nextDouble();
     System.out.println("Enter the  Constant value: ");
     double c=input.nextDouble();
     double root=b*b-4.0*a*c;
     
     if(root>0.0)
      { 
     double root1=(-b+Math.pow(root,0.5))/(2.0*a);
     double root2=(-b-Math.pow(root,0.5))/(2.0*a);
          System.out.println("Root1: "+root1+"Root2: "+root2);
      }
    else if(root==0.0)
      {
        double root1=-b/(2.0*a);
        System.out.println(root1);
       }
    else
       {
            System.out.println("Imaginary root");
       }

  }
}