/* 2. Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

Example:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output:  [1,2,4,7,5,3,6,8,9] */

import java.util.*;
public class DiagonalMatrix
{
  public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in);
     System.out.print("Enter the number Row: ");
     int m=sc.nextInt();
     System.out.print("Enter the number Coloumn: ");
     int n=sc.nextInt();
     int arr[][]=new int[m][n];
     System.out.println("Enter the Elements: ");
     for(int i=0;i<m;i++)
      {
	for(int j=0;j<n;j++)
	 {
            arr[i][j]=sc.nextInt();
	  }
      }
 int[] result=new int[m*n];
 int row=0,col=0;
 boolean up=true;
 for(int i=0;i<m*n;i++)
  {
     result[i]=arr[row][col];
     if(up)
       {
         if(col==n-1)
           {
              row++;
              up=false;
           }
         else if(row==0)
           {
              col++;
              up=false;
           }
        else
           {
              row--;
              col++;
           }
         }
      else
       {
        if(row==m-1)
	  {
            col++;
            up=true;
          } 
	 else if(col == 0)
	  {
            row++;
            up=true;
           }
	  else
	     {
               row++;
               col--;
             }
       }
   }

for(int ind=0;ind<n*m;ind++)
  {
    System.out.print(result[ind]+" ");
  }

   }
}