/*1..Write a program for dynamic binding and static binding in Java*/

import java.util.*;
class Animal
{
 void show()
   {
      System.out.println("It is Animal"); 
   } 
  static void run()
   {
      System.out.println("Animal is running");
    }

}
class Dog extends Animal 
{
   void show()
   {
      System.out.println("It is Dog");
   }
   static void run()
   {
      System.out.println("Dog is running");
    }
}
class Cat extends Animal
{
   void show()
   {
      System.out.println("It is Cat");
   }
    static void run()
   {
      System.out.println("Cat is running");
    }
}
class Tiger extends Animal
{
   void show()
   {
      System.out.println("It is Tiger");
   }
   static void run()
   {
      System.out.println("Tiger is running");
    }
}
class Dynamicform
{
public static void main(String args[])
{
    Dog dog=new Dog();
    Cat cat=new Cat();
    Tiger tiger=new Tiger();    
    dog.show();
    dog.run();
    cat.show();
    cat.run();
    tiger.show();
    tiger.run();

  System.out.println("-----After Upcasting----");
    Animal d=new Dog();
    Animal c=new Cat();
    Animal t=new Tiger();
    d.show();
    d.run();
    c.show();
    c.run();
    t.show();
    t.run();
}
}

