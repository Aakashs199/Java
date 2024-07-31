/* 3.Program to perform various operations on ArrayList. */

import java.util.*;
public class Collectiontask3
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   ArrayList<Integer> list=new ArrayList<Integer>();
   for(int i=0;i<5;i++)
    {
      list.add(sc.nextInt());
    }
   System.out.println(list);
   list.add(1);
   list.add(2);
   list.add(3);
   ArrayList<Integer> list2=new ArrayList<Integer>();
   list2.addAll(list);
   list.removeAll(list);
   System.out.println(list2);
   Iterator itr=list.iterator();
   
  }
}