/* 7.Write a Java program to convert a hash set to a List/ArrayList */

import java.util.*;
public class HassetToArrayList
{
 @SuppressWarnings("unchecked")public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   HashSet<String> set=new HashSet<>();
   System.out.print("Enter the Number of Element in List 1: ");
   int n=sc.nextInt();
   sc.nextLine();
  System.out.print("Enter the Elements: ");
  System.out.println("Enter the String Values:");
   for(int i=0;i<n;i++)
    {
      set.add(sc.nextLine());
    }
   System.out.println("Elements in HashSet: "+set);
  ArrayList<String> arraylist=new ArrayList<>(set);
  LinkedList<String> linkedlist=new LinkedList<>(set);
  System.out.println("Elements in ArrayList: "+arraylist);
  System.out.println("Elements in LinkedList: "+linkedlist);
  }
}