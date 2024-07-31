/* 1. Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:

'.' Matches any single character.​​​​
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Example 1:

Input: s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input: s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input: s = "ab", p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
 
Constraints:

1 <= s.length <= 20
1 <= p.length <= 30
s contains only lowercase English letters.
p contains only lowercase English letters, '.', and '*'.
It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.  */

  
import java.util.*;
public class MatchingString
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the String 1: ");
  String str1=sc.nextLine();
  System.out.print("Enter the String 2: ");
  String str2=sc.nextLine();
  if(str1.length()!=str2.length())
   {
      System.out.print("False");
      return;
   }
  int count=0;
  if(str1.length()==str2.length())
    {
      for(int i=0;i<str2.length();i++)
        {
          if(str2.charAt(i)==str1.charAt(i)||str2.charAt(i)=='.'||str2.charAt(i)=='*')
           {
             count++;
           }
          else
           {
             break;
           }
        }
    if(count==str2.length())
     {
        System.out.print("True");
     }
    else
     {
       System.out.print("False");
     }
    }

}
}