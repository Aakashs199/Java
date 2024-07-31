/*1.Write a Java program to clone an array list to another array list */

import java.util.*;
public class ArrayListClone
{
 @SuppressWarnings("unchecked")public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   ArrayList<Integer> list1=new ArrayList<Integer>();
   System.out.print("Enter the Number of Element in List 1: ");
   int n=sc.nextInt();
   for(int i=0;i<n;i++)
    {
      list1.add(sc.nextInt());
    }
   System.out.print("Elements in List 1: "+list1);
   System.out.println();
   ArrayList<Integer> list2=(ArrayList<Integer>)list1.clone();
   System.out.print("Elements in List 2: "+list2);
  }
}