/*2.(L2).Can we prevent overriding? if yes code it and explain it*/

import java.util.*;
class Fruit
{
  static void show()
   {
      System.out.println("It is fruit"); 
   } 
}
class Apple extends Fruit
{
     static void show()
   {
      System.out.println("It is apple");
   }
}
class Banana extends Fruit
{
     static void show()
   {
      System.out.println("It is Banana");
   }
}
class Grape extends Fruit
{
    static void show()
   {
      System.out.println("It is Grape");
   }
}
class Override
{
public static void main(String args[])
{
    Fruit a=new Apple();
    Fruit b=new Banana();
    Fruit c=new Grape();
    a.show();
    b.show();
    c.show();
}
}

