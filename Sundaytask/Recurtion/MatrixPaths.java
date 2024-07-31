/* 5. The problem is to print all the possible paths from top left to bottom right of a mXn matrix with
the constraints that from each cell you can either move only to right or down.
Examples :
Input : 1 2 3
        4 5 6
Output : 1 4 5 6
         1 2 5 6
         1 2 3 6

Input : 1 2
3 4
Output : 1 2 4
1 3 4   */



import java.util.*;
public class MatrixPaths
  {
	static int M, N;
   static void printPath(int[] path, int len)
    {
     for(int i=0;i<len;i++)
       {
         System.out.print(path[i]+" ");
        }
        System.out.println();
     }

static void findPaths(int[][] arr, int[] path, int len, int i, int j,int M,int N)
   {
     if(i ==M-1&&j==N-1)
      {
        path[len] = arr[i][j];
        printPath(path, len + 1);
        return;
      }

   if(i<0||i>=M||j<0||j>=N)
    {
      return;
    }

    path[len] = arr[i][j];
    if(j+1<N)
     {
	findPaths(arr,path,len+1,i,j+1,M,N);
     }
    if(i+1<M)
     {
	findPaths(arr,path,len+1,i+1,j,M,N);
     }
 }

public static void main(String[] args) 
  {
   	Scanner sc=new Scanner(System.in);
	int M=sc.nextInt();
	int N=sc.nextInt();
	int arr[][]=new int[M][N];
	int[] path = new int[M+N-1];
	for(int i=0;i<M;i++)
	 {
	   for(int j=0;j<N;j++)
	    {
		arr[i][j]=sc.nextInt();
	    }
	}
	int i=0,j=0;
	findPaths(arr,path,0,i,j,M,N);
  }
}