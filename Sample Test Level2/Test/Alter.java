import java.util.Scanner;
class Solution
 {
    public boolean isMatch(String s, String p)
     {
        int m=s.length(),
        int n=p.length();
        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for(int i=0;i<=m;i++) 
	{
            for(int j=1;j<=n;j++) 
	     {
                if (p.charAt(j-1)== '*')
 		  {
                    f[i][j] = f[i][j - 2];
                      if (i > 0 && (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1))) 
			{
                          f[i][j] |= f[i - 1][j];
                        }
                   } 
		else if (i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)))
  		   {
                        f[i][j] = f[i - 1][j - 1];
                   }
            }
        }
        return f[m][n];
    }
}

public class Alter 
 {
    public static void main(String[] args)
   {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the string s: ");
        String s = scanner.nextLine();
        System.out.print("Enter the pattern p: ");
        String p = scanner.nextLine();       
        Solution solution = new Solution();
        boolean result = solution.isMatch(s, p);
        System.out.println("Result: " + result);
    }
}
