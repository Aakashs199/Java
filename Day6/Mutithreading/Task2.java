/*2. (L2)Write a program to create a class MyThread in this class a constructor, call the base class constructor,
 using super and starts the thread. The run method of the class starts after this.
 It can be observed that both the main thread and the created child thread are executed concurrently. */

import java.util.*;
public class Task2 extends Thread
{
   public Task2(String str)
    {
       super(str);
    }
  public void run()
   {
    for(int i=0;i<5;i++)
     {
       try
           {
              Thread.sleep(500);  
           }
        catch(InterruptedException e)
           {
             System.out.println(e);
           }
         System.out.println("Thread "+getName()+i+" is Running");
      }
   }  
   public static void main(String args[])
   {
       Task2 ob=new Task2("Akash");
       ob.start();
   }
}