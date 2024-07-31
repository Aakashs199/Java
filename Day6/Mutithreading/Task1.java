/* 1.(L2)Write a program to illustrate creation of threads using runnable class.
(start method start each of the newly created threads. Inside the run method 
there is sleep() for suspend the thread for 500 milliseconds). */

import java.util.*;
 class Task1 implements Runnable
{
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
            System.out.println(i);
         }
    }
   public static void main(String args[])
    {
        Task1 ob=new Task1();
        Thread t=new Thread(ob);
        t.start();
    }
}