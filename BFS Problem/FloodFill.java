/* Given a 2D screen arr[][] where each arr[i][j] is an integer representing the color of that pixel, 
also given the location of a pixel (X, Y) and a color C, the task is to replace the color of the given
pixel and all the adjacent same-colored pixels with the given color.

Example: 

Input: arr[][] = { 
{1, 1, 1, 1, 1, 1, 1, 1}, 
{1, 1, 1, 1, 1, 1, 0, 0}, 
{1, 0, 0, 1, 1, 0, 1, 1}, 
{1, 2, 2, 2, 2, 0, 1, 0}, 
{1, 1, 1, 2, 2, 0, 1, 0}, 
{1, 1, 1, 2, 2, 2, 2, 0}, 
{1, 1, 1, 1, 1, 2, 1, 1}, 
{1, 1, 1, 1, 1, 2, 2, 1}} 
X = 4, Y = 4, C = 3 
Output: 
1 1 1 1 1 1 1 1 
1 1 1 1 1 1 0 0 
1 0 0 1 1 0 1 1 
1 3 3 3 3 0 1 0 
1 1 1 3 3 0 1 0 
1 1 1 3 3 3 3 0 
1 1 1 1 1 3 1 1 
1 1 1 1 1 3 3 1 
Explanation: 
The values in the given 2D screen indicate colors of the pixels. X and Y are coordinates of the brush,
C is the color that should replace the previous color on screen[X][Y] and all surrounding pixels with the same color.
Hence all the 2 are replaced with 3.  */


import java.util.*;
public class FloodFill
 {
void colorchange(int arr[][],int startrow,int startcol,int row,int col,int precolor,int newcolor)
  {
      if(startrow<0||startrow>=row||startcol<0||startcol>=col)
       {
         return;
       }
      if(arr[startrow][startcol]!=precolor)
       {
         return;     
       }
     arr[startrow][startcol]=newcolor;
      
     colorchange(arr,startrow-1,startcol,row,col,precolor,newcolor);
     colorchange(arr,startrow+1,startcol,row,col,precolor,newcolor);
     colorchange(arr,startrow,startcol+1,row,col,precolor,newcolor);
     colorchange(arr,startrow,startcol-1,row,col,precolor,newcolor);
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
System.out.println("Enter the Position");
int x=sc.nextInt();
int y=sc.nextInt();
System.out.print("Enter the Colour to be replaced: ");
int newcolor=sc.nextInt();
int precolor=arr[x][y];
FloodFill ob=new FloodFill();
ob.colorchange(arr,x,y,row,col,precolor,newcolor);
for(i=0;i<row;i++)
  {
  for(j=0;j<col;j++)
   {
      System.out.print(arr[i][j]+" ");
    }
  System.out.println();
  }
}
}