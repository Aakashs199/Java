/* 6.Write a Java program to join two linked lists. */
  

import java.util.*;
public class LinkedListJoin
{
 @SuppressWarnings("unchecked")public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   LinkedList<Integer> list1=new LinkedList<Integer>();
   System.out.print("Enter the Number of Element in List 1: ");
   int n=sc.nextInt();
  System.out.print("Enter the Elements: ");
   for(int i=0;i<n;i++)
    {
      list1.add(sc.nextInt());
    }
   System.out.print("Elements in List1: "+list1);
   System.out.println();

   LinkedList<Integer> list2=new LinkedList<Integer>();
   System.out.print("Enter the Number of Element in List 2: ");
   int m=sc.nextInt();
     System.out.print("Enter the Elements: ");
   for(int i=0;i<m;i++)
    {
      list2.add(sc.nextInt());
    }
   System.out.print("Elements in List2: "+list2);
   System.out.println();
  LinkedList<Integer> total=new LinkedList<Integer>();
  total.addAll(list1);
  total.addAll(list2);
   System.out.print("Elements After Joining: "+total);
  }
}