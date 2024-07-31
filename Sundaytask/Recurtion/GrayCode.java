/*1. Given a number n, the task is to generate n bit Gray codes (generate bit patterns from 0 to
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
public class GrayCode
 {
   public static void generateGrayCode(int n)
   {
    for(int i=0;i<Math.pow(2, n);i++) 
        {
          int gray=i^(i / 2);
          System.out.print(gray + " ");
        }
        System.out.println();
    }

    public static void main(String[] args)
     {
      Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("Gray codes for " + n + " bits:");
        generateGrayCode(n);
      }
}
