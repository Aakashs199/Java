/* 4. Longest Palindromic Subsequence (LPS)

Given a string ‘S’, find the length of the Longest Palindromic Subsequence in it.

The Longest Palindromic Subsequence (LPS) is the problem of finding a maximum-length subsequence of a given string that is also a Palindrome.

Examples:
Input: S = GEEKSFORGEEKS
Output: 5
Explanation: The longest palindromic subsequence we can get is of length 5. There are more than 1 palindromic subsequences of length 5, for example: EEKEE, EESEE, EEFEE, …etc.

Input: S = BBABCBCAB
Output: 7
Explanation: As BABCBAB is the longest palindromic subsequence in it. BBBBB and BBCBB are also palindromic subsequences of the given sequence, but not the longest ones. */


import java.util.Scanner;
class LongestPalindrome 
{
  public static int longestPalinSubseq(String S)
  {
      String R = new StringBuilder(S).reverse().toString();
      int[][] dp = new int[S.length() + 1][R.length() + 1];
     for(int i=1;i<=S.length();i++) 
        {
          for(int j=1;j<=R.length();j++) 
            {
                if(S.charAt(i-1) == R.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }

    return dp[S.length()][R.length()];
  }
public static void main(String[] args)
{
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the string:");
    String s = scanner.nextLine();
    System.out.println("The length of the LPS is " + longestPalinSubseq(s));
    }
}
