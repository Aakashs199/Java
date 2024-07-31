/* (L1).Create an abstract class 'Parent' with a method 'message'. It has two subclasses each having a method with the same name 'message' 
that prints "This is first subclass" and "This is second subclass" respectively. Call the methods 'message' by creating an object for each subclass. */



import java.util.*;
abstract class Parent
{
  abstract void message();
}
class Child1 extends Parent
{
   void message()
  {
     System.out.println("This is First Calss"); 
  }
}
class Child2 extends Parent
{
   void message()
  {
     System.out.println("This is Second Calss"); 
  }
}
public class Task1
{
public static void main(String args[])
{
 Child1 ob1=new Child1();
 Child2 ob2=new Child2();
 ob1.message();
 ob2.message();
}
}