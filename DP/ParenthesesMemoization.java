/* 1. Length of the longest valid substring using Dynamic Programming

Given a string consisting of opening and closing parenthesis, find the length of the longest valid parenthesis substring.

Examples: 

Input: ((()
Output : 2
Explanation : ()
Input: )()())
Output : 4
Explanation: ()() 
Input:  ()(()))))
Output: 6
Explanation:  ()(())

https://www.geeksforgeeks.org/length-of-the-longest-valid-substring/?ref=lbp  */

import java.util.*;
public class ParenthesesMemoization
{
static int longestparenthesis(String str)
 {
   int len=str.length();
   int maxlen=0;
   int mem[]=new int[len];
   for(int i=0;i<len;i++)
    {
     mem[i]=-1;
    }
  for(int i=0;i<len;i++)
   {
     maxlen=Math.max(maxlen,checklong(i,str,mem));
   }
 return maxlen;
 }

static int checklong(int i,String str,int mem[])
  {
    if(i<=0)
     {
	return 0;
     }

   if(mem[i]!=-1)
     {
        return mem[i];
     }
   
   if(str.charAt(i)=='(')
    {
      mem[i]=0;
    }
   else if(str.charAt(i)==')' && str.charAt(i-1)=='(')
    {
      mem[i]=checklong(i-2,str,mem)+2;
    }
   else if(str.charAt(i)==')' && str.charAt(i-1)==')');
    {
       int len=checklong(i-1,str,mem);
	if(i-1-len>=0 && str.charAt(i-1-len)=='(')
	  {
	    mem[i]=len+2+checklong(i-len-2,str,mem);
	  }
	else
	{
	  mem[i]=0;
	}
     }
     return mem[i];
  }

public static void main(String args[])
 {
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter the Parenthesis: "); 
  String str=sc.nextLine();
  System.out.print(longestparenthesis(str));
}
}