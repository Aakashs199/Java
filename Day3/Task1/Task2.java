/*2(L2).Create an abstract class 'Bank' with an abstract method 'getBalance'. $100, $150 and $200
are deposited in banks A, B and C respectively. 'BankA', 'BankB' and 'BankC' are subclasses of class
'Bank', each having a method named 'getBalance'. Call this method by creating an object of each of 
the three classes. */

import java.util.*;
abstract class Bank
{
  abstract int getbalance();
  abstract void deposit(int deposit);
}
class Bank1 extends Bank
{
    int deposit;
  void deposit(int deposit)
   {
    this.deposit=deposit;
   }
   int getbalance()
    {
     return deposit; 
    }
}
class Bank2 extends Bank
{
    int deposit;
  void deposit(int deposit)
    {
    this.deposit=deposit;
    }
   int getbalance()
     {
     return deposit;
    }
}
class Bank3 extends Bank
{
     int deposit;
  void deposit(int deposit)
    {
    this.deposit=deposit;
   }
   int getbalance()
  {
     return deposit; 
  }
}
public class Task2
{
public static void main(String args[])
{
 Bank ob1=new Bank1();
 Bank ob2=new Bank2();
 Bank ob3=new Bank3();
 ob1.deposit(100);
 ob2.deposit(150);
 ob3.deposit(200);
 System.out.println("Balance in Bank1: $"+ob1.getbalance());
 System.out.println("Balance in Bank2: $"+ob2.getbalance());
 System.out.println("Balance in Bank3: $"+ob3.getbalance());
}
}