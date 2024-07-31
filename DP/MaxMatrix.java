/* 1. Maximum size square sub-matrix with all 1s

Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

For example, consider the below binary matrix.

0 1 1 0 1
1 1 0 1 0
0 1 1 1 0
1 1 1 1 0
1 1 1 1 1
0 0 0 0 0

https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/ */

import java.util.Scanner;
public class MaxMatrix 
{
    public static void main(String[] args)
 {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int R=scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int C=scanner.nextInt();
        int[][] M=new int[R][C];

        System.out.println("Enter the matrix values row by row (0s and 1s):");
        for(int i=0;i<R;i++) 
        {
            for(int j=0;j<C;j++)
	    {
               M[i][j]=scanner.nextInt();
            }
        }
        int[][] S = new int[R][C];
        for (int i=0;i<R; i++)
	{
            S[i][0] = M[i][0];
	}
        for(int j = 0;j<C;j++)
	{
            S[0][j] = M[0][j];
 	}

        for(int i=1;i<R;i++)
	 {
            for(int j=1;j<C;j++)
	     {
                if(M[i][j] == 1)
		  {
		     int value=Math.min(S[i - 1][j],S[i - 1][j - 1]);
                     S[i][j] = Math.min(S[i][j - 1],value)+ 1;
		  }
                else
		  {
                    S[i][j]=0;
		  }
             }
        }
  System.out.println("---------");
  for(int i=0;i<R;i++) 
        {
            for(int j=0;j<C;j++)
	    {
               System.out.println(S[i][j]+" ");
            }
	   System.out.println();
        }
       int max_of_s = S[0][0];
        int max_i = 0;
        int max_j = 0;
        for(int i=0;i<R;i++)
	 {
            for(int j=0;j<C;j++) 
		{
                if(max_of_s < S[i][j])
		 {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }

        System.out.println("Maximum size sub-matrix is: ");
        for(int i=max_i;i>max_i-max_of_s; i--)
  	  {
            for(int j=max_j;j>max_j - max_of_s;j--)
  		{
                   System.out.print(M[i][j] + " ");
                 }
            System.out.println();
        }
    }
}