/* (L2).Create an abstract class 'Animals' with two abstract methods 'cats' and 'dogs'.
 Now create a class 'Cats' with a method 'cats' which prints "Cats meow" and a class 'Dogs' with a method 'dogs' 
which prints "Dogs bark", both inheriting the class 'Animals'. Now create an object for each of the sub classes and call their respective methods. */


import java.util.*;
abstract class Animal
{
  abstract void cats();
  abstract void dogs();
}
class Cats extends Animal
{
  void cats()
   {
     System.out.println("Cat meow");
   }  
  void dogs()
   {

   } 

}
class Dogs extends Animal
{
    void dogs()
   {
     System.out.println("Dog bark");
   }  
  void cats()
   {
     
   }  

}

public class Task3
{
public static void main(String args[])
{
 Animal ob1=new Cats();
 Animal ob2=new Dogs();
 ob1.cats();
 ob2.dogs();
 
 
}
}