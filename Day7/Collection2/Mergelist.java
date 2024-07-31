/* 5.Write a Java program to join two array lists. */

import java.util.*;
public class Mergelist
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   ArrayList<Integer> list1=new ArrayList<Integer>();
    ArrayList<Integer> list2=new ArrayList<Integer>();
    System.out.print("Enter the number of Element in List1: ");
    int n=sc.nextInt();
   for(int i=0;i<n;i++)
    {
      list1.add(sc.nextInt());
    }
   System.out.println("List:1 Elements: "+list1);
    System.out.print("Enter the number of Element in List2: ");
   int m=sc.nextInt();
    for(int i=0;i<m;i++)
    {
      list2.add(sc.nextInt());
    }
   System.out.println("List:1 Elements: "+list2);

   list1.addAll(list2);
   System.out.println("After Merge List: "+list1);
   
  }
}