/* 3.Write a Java program to insert elements into the linked list at the first and last position. */

import java.util.*;
public class LinkedListInsertFirstLast
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
   System.out.print("Enter the element to be Inserted First: ");
   int first=sc.nextInt();
   System.out.print("Enter the Location to be Inserted Last: ");
   int last=sc.nextInt();
   list.addFirst(first);
   list.addLast(last);
   System.out.print("Elements in LinkedList: "+list);
  }
}