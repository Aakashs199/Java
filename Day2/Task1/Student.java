/*1..Create a class named 'Student' with String variable 'name' and integer variable 'roll_no'. 
Assign the value of roll_no as '2' and that of name as "John" by creating an object of the class Student.*/

import java.util.*;
public class Student
{
   String name;
   int id;
    public Student(String name,int id)
     {
       this.name=name;
       this.id=id;
      }
    public static void main(String args[])
      {
         Student s1=new Student("John",2);
         System.out.println("Student Rollno is: "+s1.id);
         System.out.println("Student name is: "+s1.name);
      }
}