/*3.Write a program that would print the information (name, year of joining, salary, address) of three employees
by creating a class named 'Employee'. The output should be as follows:

Name          Year of joining     Address

Ashwin         1994            64C- WallsStreat

Robert         2000            68D- WallsStreat

John           1999            26B- WallsStreat*/

 

import java.util.*;
public class Employee
{
    String name;
    int year;
    String address;
   public Employee(String name,int year,String address)
     {
        this.name=name;
        this.year=year;
        this.address=address;
     }

    public static void main(String args[])
     {
         Employee a=new Employee("Ashwin",1994,"64C-WallsStreat"); 
         Employee b=new Employee("robert",2000,"68D-WallsStreat");
         Employee c=new Employee("John",1999,"26B-WallsStreat");
         System.out.println("Name"+"         "+"Year of Joining"+"         "+"Address");
         System.out.println(a.name+"       "+a.year+"                      "+a.address);
         System.out.println(b.name+"      "+b.year+"                      "+b.address);
         System.out.println(c.name+"        "+c.year+"                      "+c.address);
 
     }
}