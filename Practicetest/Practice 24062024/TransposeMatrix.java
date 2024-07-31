
import java.util.*;
public class TransposeMatrix
{
public static void main(String args[])
{
  Scanner sc=new Scanner(System.in);
  System.out.print("Enter the Number of Row: ");
  int row=sc.nextInt();
 System.out.print("Enter the Number of Coloumn: ");
  int col=sc.nextInt();
 if(row!=col)
   {
      System.out.println("Matrix must be square to transpose in place");
       return;
   }
 int arr[][]=new int[row][col];
 System.out.println("Enter the Elements: ");
 for(int i=0;i<row;i++)
  {
    for(int j=0;j<col;j++)
     {
       arr[i][j]=sc.nextInt();
     }
  }   
   
  for(int i=0;i<row;i++)
   {
     
     for(int j=i+1;j<col;j++)
       {
         int temp=arr[i][j];
	 arr[i][j]=arr[j][i];
	 arr[j][i]=temp;
       }
   }


 System.out.println("---After Transpose---");
  for(int i=0;i<row;i++)
  {
    for(int j=0;j<col;j++)
     {
        System.out.print(arr[i][j]+" ");
     }  
   System.out.println();
  } 


}
}