/* Given a binary 2D matrix, find the number of islands. A group of connected 1s forms an island. For example, the below matrix contains 4 islands.

Example: 

Input: mat[][] = {{1, 1, 0, 0, 0},
                  {0, 1, 0, 0, 1},
                  {1, 0, 0, 1, 1},
                  {0, 0, 0, 0, 0},
                  {1, 0, 1, 0, 0}}
Output: 4    */



import java.util.*;
public class Islands
{

boolean issafe(int arr[][],int row,int col,boolean visited[][],int matrixrow,int matrixcol)
{
if((row>=0)&&(col>=0)&&(row<matrixrow)&&(col<matrixcol)&&(arr[row][col]==1&&!visited[row][col]))
  {
     return true;
  }
return false;
}

 void DFS(int arr[][],int row,int col,boolean visited[][],int matrixrow,int matrixcol)
{
   int arr1[]={-1,-1,-1,0,0,1,1,1};
   int arr2[]={-1,0,1,-1,1,-1,0,1};
   visited[row][col]=true;
   for(int k=0;k<8;k++)
   {
      if(issafe(arr,row+arr1[k],col+arr2[k],visited,matrixrow,matrixcol))
        {
           DFS(arr,row+arr1[k],col+arr2[k],visited,matrixrow,matrixcol);
        }
   }
}

 int countisland(int arr[][],int row,int col)
{
   int i,j,count=0;
   boolean visited[][]=new boolean[row][col];
   for(i=0;i<row;i++)
    {
      for(j=0;j<col;j++)
      {
         if(arr[i][j]==1&&(!visited[i][j]))
           {
              DFS(arr,i,j,visited,row,col);
              count++;
           }
      }
    }
  return count;
}

public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
System.out.print("Enter the number of Rows: ");
int row=sc.nextInt();
System.out.print("Enter the number of coloumn: ");
int col=sc.nextInt();
int i,j;
int arr[][]=new int[row][col];
for(i=0;i<row;i++)
{
  for(j=0;j<col;j++)
   {
      arr[i][j]=sc.nextInt();
    }
}
Islands ob=new Islands();
System.out.println("The Number of Islands are: "+ob.countisland(arr,row,col));
}
}