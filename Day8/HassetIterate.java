/* 8.Write a Java program to iterate through all elements in a hash list. */

import java.util.*;
public class HassetIterate
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
  System.out.println("---Iterating the HasSet---");
  Iterator<String>itr=set.iterator();
 while(itr.hasNext())
  {
    System.out.println(itr.next());
  }
  }
}