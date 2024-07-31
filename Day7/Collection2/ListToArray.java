/* 3.Convert list to array */

import java.util.*;
public class ListToArray
{
 public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number of Element: ");
   int n=sc.nextInt();
   ArrayList<Integer> list=new ArrayList<Integer>();
   for(int i=0;i<n;i++)
    {
      list.add(sc.nextInt());
    }
   System.out.println(list);
   int arr[]=new int[list.size()];
  for(int i=0;i<n;i++)
   {
     arr[i]=list.get(i);
   }
  for(int i=0;i<n;i++)
  {
    System.out.print(arr[i]+" ");
  }
   
  }
}