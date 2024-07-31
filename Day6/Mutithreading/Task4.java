/* (L3)Write a program to create two threads. In this class we have one constructor used to start the thread and run it. 
Check whether these two threads are run are not. */

import java.util.*;
class Task4 extends Thread
{

  public Task4(String str)
   {
      super(str);
   }
  public void run()
{
   for(int i=0;i<6;i++)
    {
      try
        {
           Thread.sleep(1000);
        }
       catch(InterruptedException e)
        {
          System.out.println(e);
        }
      System.out.println(Thread.getName()+": "+i);
    }
}
 public static void main(String args[])
  {
   Task4 t1=new Task4("Thread1");
   Task4 t2=new Task4("Thread2");
   t1.start();
   t2.start();
  }
}