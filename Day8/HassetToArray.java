/* 9.Write a Java program to convert a hash set to a Array */

import java.util.*;
public class HassetToArray
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
   String arr[]=new String[set.size()];
   int ind=0;
   for(String element: set)
    {
      arr[ind]=element;
      ind++;
    }
  System.out.println("----Elements in Array---");
   for(String value: arr)
    {
      System.out.print(value+" ");
    }
  }
}