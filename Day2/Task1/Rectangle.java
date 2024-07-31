/*2.Write a program to print the area of two rectangles having sides (4,5) and (5,8) respectively by creating a class
 named 'Rectangle' with a method named 'Area' which returns the area and length and breadth passed as parameters to its constructor.*/

import java.util.*;
public class Rectangle
 {
    int length;
    int breath; 
    public Rectangle(int length,int breath)
      {
         this.length=length;
         this.breath=breath;
      } 
     public int area()
     {
        return length*breath;   
     }
    public static void main(String args[])
       {
          Rectangle r1=new Rectangle(4,5);
          Rectangle r2=new Rectangle(5,8);
          System.out.println("The area of the Rectangle 1 is: "+r1.area());
          System.out.println("The area of the Rectangle 2 is: "+r2.area());
        }
 }