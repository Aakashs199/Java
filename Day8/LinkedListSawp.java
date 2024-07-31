/* 5. Write a Java program of swap two elements in a linked list. */

import java.util.*;
public class LinkedListSawp
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
   System.out.print("Elements in Before Swap: "+list);
   System.out.println();
   System.out.print("Enter the First element to be Swap: ");
   int element1=sc.nextInt();
   System.out.print("Enter the Second element to be Swap: ");
   int element2=sc.nextInt();
   int ind1=list.indexOf(element1);
   int ind2=list.indexOf(element2);
   if(ind1==-1||ind2==-1)
    {
       System.out.print("Elements not Present in List");
       return;
    }
  else
    {
       list.set(ind1,element2);
       list.set(ind2,element1);
    }
   System.out.print("Elements in After Swap: "+list);
  }
}