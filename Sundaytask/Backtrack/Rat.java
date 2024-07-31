/* 1.You are given a maze in the form of a matrix of size n * m. Each cell is either clear or blocked 
denoted by 1 and 0 respectively.
 A rat sits at the top-left cell and there exists a block of cheese at the bottom-right cell. Both these 
cells are guaranteed to be clear.
 You need to find if the rat can get the cheese if it can move only in one of the two directions - down 
and right. It can’t move to blocked cells.
 Input Format
 The first line contains an integer ‘T’, denoting the number of test cases.
 For each test case the input has the following lines:
 • The first line contains two space-separated integers ‘n’ and ‘m’ denoting the number of rows 
and columns of the matrix respectively.
 • The next n lines contain m space-separated integers which are either 0 or 1.
 Output Format 
For each test case, a line containing 1 or 0 based on whether the rat can get the cheese or not 
respectively.
 Sample Input
 4
 4 4
 1 1 0 0
 1 1 1 1
 0 1 0 1
 0 1 0 1
 4 4
 1 1 0 0
 1 1 1 1
 0 1 1 0
 0 1 0 1
 4 5
 1 0 1 1 1
 1 1 1 0 1
0 1 0 0 1
 0 1 1 0 1
 3 4
 1 0 0 0
 0 0 0 0
 0 0 1 1
 Expected output
 1
 0
 0
 0
 Constraint
 1 <= T <= 100
 1 <= n, m <= 100
 0 <= mazeij <= 1   */


import java.util.*;
public class Rat
{
 static boolean issafe(int arr[][],int x,int y,int row,int col)
   {
     if(x>=0 && y>=0 && x<row && y<col && arr[x][y]==1)
        {
	   return true;
	}
	return false;
   }
   static void printsol(int sol[][],int row,int col)
	{
	  for(int i=0;i<row;i++)
		{
		   for(int j=0;j<col;j++)
		    {
                       System.out.print(sol[i][j]+" ");
		    }
                System.out.println();
		}
	}

 static boolean isroute(int arr[][],int sol[][],int x,int y,int row,int col)
   {
      if(x==row-1&&y==col-1)
       {
           sol[x][y]=1;
           return true;
       }
      if(issafe(arr,x,y,row,col)==true)
       {
          sol[x][y]=1;
           if(isroute(arr,sol,x+1,y,row,col)==true)
            {
              return true;
            }
            if(isroute(arr,sol,x,y+1,row,col)==true)
            {
              return true;
            }
          sol[x][y]=0;
          return false;
       }
     return false;
   }


static boolean solverat(int arr[][],int row,int col)
  {
     int sol[][]=new int[row][col];
     for(int i=0;i<row;i++)
      {
         for(int j=0;j<col;j++)
          {
             sol[i][j]=0;
          }
      }
   if(isroute(arr,sol,0,0,row,col)==false)
    {
      System.out.print("Solution Does not exsist"); 
      return false;
    }
   printsol(sol,row,col);
   return true;  
  }

public static void main(String args[])
 {
   Scanner sc=new Scanner(System.in);
   System.out.print("Enter the Number of Rows: ");
   int row=sc.nextInt();
   System.out.print("Enter the Number of Coloumn: ");
   int col=sc.nextInt();
   int arr[][]=new int[row][col];
   for(int i=0;i<row;i++)
    {
     for(int j=0;j<col;j++)
      {
         arr[i][j]=sc.nextInt();
      }
    }

  System.out.println("The routes are: ");
  solverat(arr,row,col);

}
}