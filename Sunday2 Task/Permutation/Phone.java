/* Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return
the answer in any order. A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to
any letters.
1 2 3
abc def
4 5 6
ghi jkl mno
7 8 9
pqrs tuv wxyz

Examples:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Input: digits = ""
Output: []
Input: digits = "2"
Output: ["a","b","c"]
Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9']
https://leetcode.com/problems/letter-combinations-of-a-phone-number/    */




import java.util.*;
public class Phone
{
  final char[][] L={ {},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String str) 
     {
        int len=str.length();
        List<String> ans = new ArrayList<>();
        if(len==0)
         {
           return ans;
         }
         bfs(0,len,new StringBuilder(),ans,str);
         return ans;
     }

 public void bfs(int pos, int len, StringBuilder sb, List<String> ans, String D)
    {
      if(pos==len)
       {
          ans.add(sb.toString());
       }
       else
        {
          char[] letters = L[Character.getNumericValue(D.charAt(pos))];
          for(int i=0;i<letters.length;i++)
	   {
             bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), ans, D);
	   }
        }
    }

public static void main(String[] args) 
  {
     Phone phone = new Phone();
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the digits (2-9): ");
     String digits=sc.nextLine();
     List<String> combinations = phone.letterCombinations(digits);
     System.out.println("Letter combinations: " + combinations);
    }
}
