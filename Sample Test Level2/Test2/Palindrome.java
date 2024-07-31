/*2.From the input sentence given, find the strings which are not palindrome and print it.
Input: he knows malayalam
Output: he knows*/

import java.util.*;
public class Palindrome
 {
 static boolean palindrome(String word) 
 {
  int start=0;
  int end=word.length()-1;
  while(start<end)
   {
    if(word.charAt(start)!=word.charAt(end))
     {
       return false;
     }
   start++;
   end--;
   }
  return true;
    }
 public static void main(String args[])
  {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the String : ");
   String str=sc.nextLine();
   int start=0;
   for(int i=0;i<str.length();i++)
    {
     if(str.charAt(i)==' '||i==str.length()-1) 
      {
        if(i==str.length()-1)
         {
          i++;
         }
        String word=str.substring(start,i);
        if (!palindrome(word)) 
         { 
          System.out.print(word + " ");
         }
        start=i+1;
       }
     }
    }
}
