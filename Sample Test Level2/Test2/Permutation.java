/* 4.Print all distinct permutations of a string having duplicates.
Input: ABCA
Output: AABC AACB ABAC ABCA ACBA ACAB BAAC BACA BCAA CABA CAAB
CBAA*/

import java.util.*;
public class Permutation
 {
  boolean verify(char str[],int start,int curr)
   {
   for(int i=start;i<curr;i++)
    {
      if(str[i]==str[curr])
       {
         return false;
        }
     }
      return true;
   }
 void swap(char[] str,int start,int end)
   {
     char temp=str[start];
     str[start]=str[end];
     str[end]=temp;
    }

 void permutate(String str,int index,int n)
   {
     if(index>=n)
       {
         System.out.println(str);
         return;
       }
    for(int i=index;i<n;i++)
     {
      boolean check=verify(str.toCharArray(),index,i);
      if(check)
        {
          char[] charArray = str.toCharArray();
          swap(charArray, index, i);
          str=new String(charArray);
          permutate(str, index + 1, n);
          swap(charArray, index, i);
          str=new String(charArray);
         }
        }
    }
 public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter a number of characters: ");
    int n=sc.nextInt();
    char str[] = new char[n];
    System.out.println("Enter the characters: ");
    for(int i=0;i<n;i++)
     {
       str[i] = sc.next().charAt(0);
     }
    Permutation permutation = new Permutation();
    permutation.permutate(new String(str), 0, n);
    }
}
