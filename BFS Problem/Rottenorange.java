/* Given a matrix of dimension M * N, where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:  

0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges
The task is to the minimum time required so that all the oranges become rotten. A rotten orange at index (i,j ) can rot other fresh oranges which are its neighbors (up, down, left, and right). If it is impossible to rot every orange then simply return -1.

banner
Minimum time required to rotten all oranges

Examples: 

Input:  arr[][C] = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
Output: 2
Explanation: At 0th time frame:
{2, 1, 0, 2, 1}
{1, 0, 1, 2, 1}
{1, 0, 0, 2, 1}
At 1st time frame:
{2, 2, 0, 2, 2}
{2, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
At 2nd time frame:
{2, 2, 0, 2, 2}
{2, 0, 2, 2, 2}
{2, 0, 0, 2, 2}

Input:  arr[][C] = { {2, 1, 0, 2, 1}, {0, 0, 1, 2, 1}, {1, 0, 0, 2, 1}}
Output: -1
Explanation: At 0th time frame:
{2, 1, 0, 2, 1}
{0, 0, 1, 2, 1}
{1, 0, 0, 2, 1}
At 1st time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
At 2nd time frame:
{2, 2, 0, 2, 2}
{0, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
The 1 at the bottom left corner of the matrix is never rotten.    */



import java.util.*;
class Rottenorange
{
 static boolean issafe(int i,int j,int row,int col)
 {
    return (i >= 0 && j >= 0 && i < row && j < col);
 }
 static int orange(int arr[][],int row,int col)
   {
     boolean changed = false;
     int no = 2;
     while (true)
      {
        for(int i=0;i<row;i++)
         {
           for(int j=0;j<col;j++)
            {
               if(arr[i][j]==no)
                 {
                   if(issafe(i+1,j,row,col) &&arr[i+1][j]==1)
                     {
                       arr[i+1][j] = arr[i][j]+1;
                       changed=true;
                     }
                    if(issafe(i,j+1,row,col) && arr[i][j+1]==1)
                     {
                       arr[i][j+1] = arr[i][j]+1;
                       changed = true;
                     }
                     if(issafe(i - 1, j, row, col) && arr[i - 1][j] == 1)
                      {
                        arr[i - 1][j] = arr[i][j] + 1;
                        changed = true;
                      }
                      if(issafe(i, j - 1, row, col) && arr[i][j - 1] == 1) 
                      {
                            arr[i][j - 1] = arr[i][j] + 1;
                            changed = true;
                      }
                    }
                }
            }

            if(!changed) 
            {
                break;
            }
        System.out.println("After the Iteration");
          for(int i = 0; i < row; i++)
          {
            for(int j = 0; j < col; j++)
               {
                System.out.print(arr[i][j]+" ");
               }
            System.out.println();
           }
            changed = false;
            no++;
        }

        for(int i = 0; i < row; i++)
          {
            for(int j = 0; j < col; j++)
               {
                if (arr[i][j] == 1)
                 {
                    return -1;
                }
            }
        }
        return no-2;
    }

 public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows:");
    int row = sc.nextInt();
    System.out.println("Enter the number of columns:");
    int col = sc.nextInt();
    int arr[][] = new int[row][col];
    System.out.println("Enter the elements of the grid (0 for empty cell, 1 for fresh orange):");
    for(int i=0;i<row;i++)
     {
       for(int j=0;j<col;j++)
        {
          arr[i][j] = sc.nextInt();
        }
     }
     System.out.println("Minimum time required to rot all oranges: " + orange(arr, row, col));
    }
}
