/*6. Given two dimensional matrix of integer and print the rectangle can be formed using given
indices and also find the sum of the elements in the rectangle.
Input:
mat[M][N] = {{1, 2, 3, 4, 6},
{5, 3, 8, 1, 2},
{4, 6, 7, 5, 5},
{2, 4, 8, 9, 4}};
index = (2, 0) and (3, 4)
Output:
Rectangle = {4 6 7 5 5}{2 4 8 9 4}
Sum=54*/


import java.util.*;
public class Rectangle
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the rows: ");
  int row=sc.nextInt();
  System.out.print("Enter the coloumn: ");
  int col=sc.nextInt();
  int arr[][]=new int[row][col];
  int i,j,sum=0;
  for(i=0;i<row;i++)
   {
      for(j=0;j<col;j++)
       {
         arr[i][j]=sc.nextInt();
       }
   }
  System.out.println("Enter the Start position: ");
  int a=sc.nextInt();
  int b=sc.nextInt();
  System.out.println("Enter the End position: ");
  int c=sc.nextInt();
  int d=sc.nextInt();

  for(i=a;i<=c;i++)
   {
     for(j=b;j<=d;j++)
      {
          sum+=arr[i][j];
      }
    }
 System.out.println("Sum of Rectangle: "+sum);
}
}