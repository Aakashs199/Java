import java.util.*;
public class Colouring
{
static void colorchange(int arr[][],int srow,int scol,int row,int col,int precolor,int newcolor)
  {
   if(srow<0||srow>=row||scol<0||scol>=col)
   {
     return;
   }
  if(arr[srow][scol]!=precolor)
    {
      return;     
   }
     arr[srow][scol]=newcolor;
      
  colorchange(arr,srow-1,scol,row,col,precolor,newcolor);
   colorchange(arr,srow+1,scol,row,col,precolor,newcolor);
    colorchange(arr,srow,scol+1,row,col,precolor,newcolor);
   colorchange(arr,srow,scol-1,row,col,precolor,newcolor);
  } 

public static void main(String args[])
{
 Scanner sc=new Scanner(System.in);
 System.out.print("Enter the Row: ");
 int row=sc.nextInt();
 System.out.print("Enter the Coloumn: ");
 int col=sc.nextInt();
 int i,j;
 System.out.println("Enter the Values: ");
 int arr[][]=new int[row][col];
 for(i=0;i<row;i++)
  {
   for(j=0;j<col;j++)
    {
      arr[i][j]=sc.nextInt();
    }
  }
  System.out.println("Enter the Source Row and Coloumn: ");
  int srow=sc.nextInt();
  int scol=sc.nextInt();
  System.out.print("Enter the Color to change: ");
  int color=sc.nextInt();
  int precolor=arr[srow][scol];
  colorchange(arr,srow,scol,row,col,precolor,color);
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