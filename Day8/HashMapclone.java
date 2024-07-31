/* 10. Write a Java program to get a shallow copy of a HashMap instance. */

import java.util.*;
public class HashMapclone
{
 @SuppressWarnings("unchecked")public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   HashMAp<Integer,String> map=new HashMap<Integer,String>();
   System.out.print("Enter the Number of Element in List 1: ");
   int n=sc.nextInt();
   sc.nextLine();
  System.out.print("Enter the Elements: ");
  System.out.println("Enter the String Values:");
   for(int i=0;i<n;i++)
    {
      int a=sc.nextInt();
      String str=sc.nextLine();
      map.put(a,str);
    }

  }
}