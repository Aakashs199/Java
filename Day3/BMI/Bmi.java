/* (L3).Create a BMI calculator by using packages and it should follows,

Create a package file 1 that contains a class that accepts a basic data members need for your calculator.
Create a crisp method to calculate a BMI and return the result
Create another package file and create an object for the file 1 class and pass the respective arguments then call the method */

import calculator.Calculation;
import java.util.*;
public class Bmi
{
  public static void main(String args[])
  {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter the value of Height: ");
      double height=sc.nextInt();
      System.out.println("Enter the value of Weight: ");
      double weight=sc.nextInt();
      Calculation calculate=new Calculation(height,weight);
      System.out.println("Your BMI is: "+calculate.calculateBmi());
       
  }
}