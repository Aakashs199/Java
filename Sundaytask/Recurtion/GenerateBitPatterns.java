/* 1.1. Given a number n, the task is to generate n bit Gray codes (generate bit patterns from 0 to
2^n-1
such that successive patterns differ by one bit)
Examples:
Input : 2
Output : 0 1 3 2
Explanation :
00 - 0
01 - 1
11 - 3
10 - 2
Input : 3
Output : 0 1 3 2 6 7 5 4*/


import java.util.*;
public class GenerateBitPatterns
  {
    public static String[] generateBitPatterns(int N)
    {
      int totalPatterns = (int) Math.pow(2, N);
      String[] patterns = new String[totalPatterns];
      generatePatterns(N,"",patterns,0);
      return patterns;
    }

   private static int generatePatterns(int N, String pattern, String[] patterns, int index)
    {
      if(N == 0)
	{
	   patterns[index] = pattern;
	   return index + 1;
	}
	index=generatePatterns(N-1,pattern+0,patterns,index);
	index=generatePatterns(N-1,pattern+1,patterns,index);

	return index;
  }

  public static void main(String[] args)
   {
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter the N value: ");
	int N=sc.nextInt();
	System.out.println("Bit patterns for N :");
	String[] patterns1 = generateBitPatterns(N);
	for(String pattern : patterns1)
	 {
	    System.out.println(pattern);
	 }

  }
 }