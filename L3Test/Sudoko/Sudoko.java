import java.util.*;
public class Sudoko
{
static int size=9;
static int row=3;
static int col=3;

public static void displayBoard(char arr[][])
{
System.out.println("--------------------");
  for(int i=0;i<9;i++)
	{
	   for(int j=0;j<9;j++)
	     {
		System.out.print(arr[i][j]+" ");
	     }
	   System.out.println();
	}
System.out.println("--------------------");
}


public static boolean validBoard(char board[][])
{
   for(int i=0;i<size;i++)
    {
        boolean[] rowCheck = new boolean[size];
        boolean[] colCheck = new boolean[size];
        for(int j=0;j<size;j++) 
	  {
             if(!isValidRowCol(board[i][j],rowCheck)) 
		{
                  return false;
                }
             if(!isValidRowCol(board[j][i],colCheck)) 
		{
                  return false;
                }
          }
     }

  for(int i=0;i<size;i+=3)
   {
     for(int j=0;j<size;j+=3)
	 {
            if(!isValidBox(board,i,j))
	      {
                    return false;
              }
          }
    }
        
 return true;
}

static boolean isValidRowCol(char c,boolean[] check)
  {
      if(c=='.') 
	{
            return true;
        }
       int num=c-'1';
       if(num<0||num>=size||check[num])
	 {
            return false;
         }
       check[num]=true;
       return true;
    }

static boolean isValidBox(char[][] board, int ind1, int ind2)
 {
    boolean[] boxCheck=new boolean[size];
    for(int i=ind1;i<ind1+3;i++)
	 {
           for(int j=ind2;j<ind2+3;j++)
	     {
                if(!isValidRowCol(board[i][j],boxCheck))
		 {
                    return false;
                 }
            }
        }
        return true;
    }


static boolean solveSudoku(char[][] board)
 {
   int[] position=findPosition(board);
        if(position==null)
	 {
            return true;
         }
   int row=position[0];
   int col=position[1];

   for(char c='1';c<='9';c++)
	 {
           if(isValidMove(board,row,col,c)) 
		{
                  board[row][col]=c;
                  if(solveSudoku(board))
		  {
                     return true;
                  }
                 board[row][col] = '.';
               }
	  // displayBoard(board);
        }
        return false; 
    }

 static boolean isValidMove(char[][] board,int row,int col,char c)
    {
      for(int i=0;i<size;i++)
	 {
            if(board[row][i]==c||board[i][col]==c)
	    {
                return false;
            }
        }

   int boxRow = row-row%3;
   int boxCol = col-col%3;

   for(int i=boxRow;i<boxRow+3;i++)
	 {
            for(int j=boxCol;j<boxCol+3;j++)
	      {
                if(board[i][j]==c)
		 {
                    return false;
                 }
            }
        }
     return true;
    }


static int[] findPosition(char[][] board)
   {
    for(int i=0;i<size;i++)
	{
           for(int j=0;j<size;j++)
	      {
                 if(board[i][j]=='.')
	      	 {
                   return new int[]{i,j};
                 }
            }
        }
        return null;
   }


public static void main(String args[])
   {
   	Scanner sc=new Scanner(System.in);
	char board[][]=new char[9][9];
	for(int i=0;i<9;i++)
	{
	   for(int j=0;j<9;j++)
	     {
		board[i][j]=sc.next().charAt(0);
	     }
	}
	displayBoard(board);


    if(validBoard(board))
	{
	    if(solveSudoku(board))
	    {
	      displayBoard(board);
            }
	    else
	    {
	       System.out.println("Not Able to Solve");
	    }
	}
     else
	{
	   System.out.println("Not a Valid Box");
	}
  }
}