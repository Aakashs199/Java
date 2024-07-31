/* (L2)Write a program to get the reference to the current thread by calling currentThread() method. */

import java.util.*;
public class Task3 extends Thread
{
 public static void main(String args[])
  {
    Thread ob=Thread.currentThread();
    System.out.println(ob.getName());
    System.out.println(ob.getPriority());
    System.out.println(ob.getId());
    System.out.println(ob.getState());
    System.out.println(ob.getThreadGroup());
    System.out.println(ob);
  }
}