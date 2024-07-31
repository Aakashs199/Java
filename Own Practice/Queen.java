import java.util.*;
public class Queen
{

public static void printBoard(char board[][],int n)
{
    for(int i=0;i<n;i++)
	{
	  for(int j=0;j<n;j++)
	   {
    		System.out.print(board[i][j]+" ");
	   }
	System.out.println();
	}
}


public static void solve(int col,char board[][],int n,int left[],int lower[],int upper[])
  {
     if(col==n)
	{
	   printBoard(board,n);
	   System.out.println("*****************");
	   return;
	}
     for(int row=0;row<n;row++)
	{
		if(left[row]==0 && lower[row+col]==0 && upper[n-1+col-row]==0)
		{
		    board[row][col]='Q';
		    left[row]=1;
		    lower[row+col]=1;
		    upper[n-1+col-row]=1;
		    solve(col+1,board,n,left,lower,upper);
		    board[row][col]='-';
		    left[row]=0;
		    lower[row+col]=0;
		    upper[n-1+col-row]=0;
		}
	     
	}
  }

  public static void main(String args[])
  {
    Scanner sc=new Scanner(System.in);
    System.out.print("Enter the Value of N: ");
    int n=sc.nextInt();
    char board[][]=new char[n][n];
    for(int i=0;i<n;i++)
	{
	  for(int j=0;j<n;j++)
	   {
    		board[i][j]='-';
	   }
	}
   int left[]=new int[n];
   int lower[]=new int[2*n-1];
   int upper[]=new int[2*n-1];
   solve(0,board,n,left,lower,upper);
   
   
  }
}