/* 2.Write a Java program to insert the specified element at the specified position in the linked list */

import java.util.*;
public class LinkedListInsert
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
   System.out.print("Enter the element to be Inserted: ");
   int element=sc.nextInt();
   System.out.print("Enter the Location to be Inserted: ");
   int location=sc.nextInt();
   list.add(location,element);
   System.out.print("Elements in LinkedList: "+list);
  }
}