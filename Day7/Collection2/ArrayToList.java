/* 4.Convert Array to list */

import java.util.*;
public class ArrayToList
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number of Element: ");
   int n=sc.nextInt();
   int arr[]=new int[n];
   for(int i=0;i<n;i++)
   {
     arr[i]=sc.nextInt();
   }
   System.out.println("----Array Elements----");
  for(int i=0;i<n;i++)
  {
    System.out.print(arr[i]+" ");
  }
   System.out.println();
   ArrayList<Integer> list=new ArrayList<Integer>();
   for(int i=0;i<n;i++)
    {
      list.add(arr[i]);
    }
  System.out.println("---List Elements---");
   System.out.println(list);
  
  
  }
}