/* (L3).We have to calculate the percentage of marks obtained in three subjects (each out of 100) by student A
 and in four subjects (each out of 100) by student B. Create an abstract class 'Marks' with an abstract method 'getPercentage'.
 It is inherited by two other classes 'A' and 'B' each having a method with the same name which returns the percentage of the students. 
The constructor of student A takes the marks in three subjects as its parameters and the marks in four subjects as its parameters for student B. 
Create an object for each of the two classes and print the percentage of marks for both the students. */

import java.util.*;
abstract class Marks
{
  abstract double getpercentage();
}
class StudentA extends Marks
{
   int mark1,mark2,mark3;
   StudentA(int mark1,int mark2,int mark3)
    {
      this.mark1=mark1;
      this.mark2=mark2;
      this.mark3=mark3;
    }
   double getpercentage() 
  {
      return (mark1+mark2+mark3)/3;
  }
}
class StudentB extends Marks
{
   int mark1,mark2,mark3,mark4;
   StudentB(int mark1,int mark2,int mark3,int mark4)
    {
      this.mark1=mark1;
      this.mark2=mark2;
      this.mark3=mark3;
      this.mark4=mark4;
    }
   double getpercentage() 
  {
      return (mark1+mark2+mark3+mark4)/4;
  }
}
public class Task4
{
  public static void main(String args[])
{
   Marks ob1=new StudentA(89,78,90);
   Marks ob2=new StudentB(56,89,90,87);
   System.out.println(ob1.getpercentage());
   System.out.println(ob2.getpercentage());
 
}
}