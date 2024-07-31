/* 4.Write a Java program to remove a specified element from a linked list. */

import java.util.*;
public class LinkedListRemoveElement
{
 @SuppressWarnings("unchecked")public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   LinkedList<Integer> list=new LinkedList<Integer>();
   System.out.print("Enter the Number of Element in List 1: ");
   int n=sc.nextInt();
   for(int i=0;i<n;i++)
    {
      list.add(sc.nextInt());
    }
   System.out.print("Elements in LinkedList: "+list);
   System.out.println();
   System.out.print("Enter the element to be Removed: ");
   int element=sc.nextInt();
   Integer ob=new Integer(element);
   list.remove(ob);
   System.out.print("Elements in LinkedList: "+list);
  }
}