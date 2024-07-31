/* 5. Decode Ways: A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.

Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of the leading zero ("6" is different from "06").

Constraints:

1 <= s.length <= 100
s contains only digits and may contain leading zero(s).

https://leetcode.com/problems/decode-ways/     */




import java.util.Scanner;
public class Encode 
{
    public static void main(String[] args) 
     {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String of digits: ");
        String s=sc.nextLine();
        decodeWays(s);
     }

  public static void decodeWays(String number)
   {
        if(number==null ||number.length()==0) 
	{
            return;
        }
      backtrack(number,"",0);
    }

 public static void backtrack(String number,String current,int start)
   {
	System.out.println(number+" "+current+" "+start);
        if(start == number.length())
	 {
           System.out.println(current);
           return;
         }

        char singleChar = number.charAt(start);
        if(singleChar!='0') 
	{
          char singleLetter = (char)('A'+(singleChar-'1'));
          backtrack(number, current+singleLetter, start+1);
        }
      // System.out.println("-----*****-------"+start);
        if(start+1<number.length())
	 {	
		
            char firstChar=number.charAt(start);
            char secondChar=number.charAt(start+1);
            int twoDigit=(firstChar-'0')*10 + (secondChar-'0');

            if(twoDigit>=10 && twoDigit<=26) 
		{	
		  System.out.println("------------"+number+" "+current+" "+start);
                  char twoLetter=(char)('A'+(twoDigit-1));
                  backtrack(number,current+twoLetter,start+2);
                }
        }
    }
}
