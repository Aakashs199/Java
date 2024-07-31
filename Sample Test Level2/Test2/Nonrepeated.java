/* 1.Two strings of equal length will be given. Print all the adjacent pairs which are not equal.
Input: asdfghij and adsfgijh
Output: sd-ds, hij-ijh*/

import java.util.*;
public class Nonrepeated
 {
 public static void main(String args[]) 
  {
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the String1: ");
  String str1 = sc.nextLine();
  System.out.print("Enter the String2: ");
  String str2 = sc.nextLine();
  String a = "";
  String b = "";
  for (int i=0;i<Math.min(str1.length(),str2.length());i++)
  {
     if(str1.charAt(i)!=str2.charAt(i))
      {
        a+=str1.charAt(i);
        b+=str2.charAt(i);
      } 
      else
       {
         if(!a.isEmpty()&&!b.isEmpty())
           {
            System.out.println(a+"-"+ b);
            a = "";
            b = "";
           }
        }
   }

    if(!a.isEmpty()&&!b.isEmpty())
     {
            System.out.print(a+ "-" +b+",");
     }
    }
}
