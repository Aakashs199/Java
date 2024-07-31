/* 10. Minimum insertions to form a palindrome | DP-28

Given string str, the task is to find the minimum number of characters to be inserted to convert it to a palindrome.

Before we go further, let us understand with a few examples: 

ab: Number of insertions required is 1 i.e. bab
aa: Number of insertions required is 0 i.e. aa
abcd: Number of insertions required is 3 i.e. dcbabcd
abcda: Number of insertions required is 2 i.e. adcbcda which is the same as the number of insertions in the substring bcd(Why?).
abcde: Number of insertions required is 4 i.e. edcbabcde

https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-dp-28/  */


import java.util.Scanner;
public class InsertPalindrome 
{

    static int Lcs(String X, String Y, int m, int n)
    {
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];
        int i, j;
        for(i=0;i<=m;i++)
        {
            for(j=0;j<=n;j++)
            {
                if (i == 0 || j == 0)
                {
                    prev[j] = 0;
                }
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                {
                    curr[j] = prev[j - 1] + 1;
                }
                else
                {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
        prev = curr.clone();
        }
    return prev[n];
    }
    
    static int FindMinInsertionsLCS(String str, int n)
    {
        StringBuilder tmp = new StringBuilder();
        tmp.append(str);
        tmp.reverse();
        String rev = tmp.toString();
        return (n - Lcs(str, rev, n, n));
    }

    public static void main(String[] args) 
    {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter the string:");
    String str = scanner.nextLine();
    int result = FindMinInsertionsLCS(str, str.length());
    System.out.println("Minimum number of insertions needed: " + result);
    }
}

